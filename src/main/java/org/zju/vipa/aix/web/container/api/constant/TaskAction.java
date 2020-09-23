package org.zju.vipa.aix.web.container.api.constant;

/**
 * @Date: 2020/9/21 15:28
 * @Author: EricMa
 * @Description: 任务控制动作枚举
 */
public enum TaskAction {
    /**
     * 终止任务
     */
    STOP("stop");

    String action;

    TaskAction(String action) {
        this.action = action;
    }


    public boolean isMatch(String action) {
        return this.action.equals(action);
    }
}
