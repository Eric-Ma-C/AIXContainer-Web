package org.zju.vipa.aix.web.container.api.entity;

import java.util.List;

/**
 * @Date: 2020/6/9 15:43
 * @Author: EricMa
 * @Description: todo:
 */
public class ListWithTotal{
    private int total=0;
    private List items;

    public ListWithTotal(List items) {
        this.items = items;
        this.total= items.size();
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
