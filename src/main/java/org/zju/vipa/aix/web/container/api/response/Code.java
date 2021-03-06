package org.zju.vipa.aix.web.container.api.response;

/**
 * @Date: 2020/12/1 19:22
 * @Author: EricMa
 * @Description: 状态值
 */
public enum Code {
    SUCCESS(20000),
    FAILED(30000),
    EXCEPTION(50000),
    NULL(60000);

    private int value;
    Code(int i) {
        this.value=i;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
