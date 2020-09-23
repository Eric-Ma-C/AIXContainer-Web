package org.zju.vipa.aix.web.container;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date: 2020/6/10 14:02
 * @Author: EricMa
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        int sum = 5;
        Philosopher[] philosophers = new Philosopher[sum];
        ReentrantLock table = new ReentrantLock();
        for (int i = 0; i < sum; i++) {
            philosophers[i] = new Philosopher(table, i);
        }
        for (int i = 0; i < sum; i++) {
            philosophers[i].setLeft(philosophers[(i - 1 + sum) % sum]);
            philosophers[i].setRight(philosophers[(i + 1) % sum]);
        }
        for (int i = 0; i < sum; i++) {
            exec.execute(philosophers[i]);
        }
    }
}

class Philosopher extends Thread {
    private boolean eating;
    private Philosopher left;
    private Philosopher right;
    private ReentrantLock table;
    private Condition condition;
    int name;

    public Philosopher(ReentrantLock table, int name) {
        eating = false;
        this.table = table;
        condition = table.newCondition();
        this.name = name;
    }

    public void setLeft(Philosopher left) {
        this.left = left;
    }

    public void setRight(Philosopher right) {
        this.right = right;
    }

    public void think() throws InterruptedException {
        table.lock();
        try {
            eating = false;
            System.out.println(name + " 开始思考");
            left.condition.signal();
            right.condition.signal();
        } finally {
            table.unlock();
        }
        Thread.sleep(1000);
    }

    public void eat() throws InterruptedException {
        table.lock();
        try {
            while (left.eating || right.eating)
                condition.await();

            System.out.println(name + " 开始吃饭");
            eating = true;
        } finally {
            table.unlock();
        }
        Thread.sleep(1000);
    }

    public void run() {
        try {
            while (true) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
        }
    }
}
