package org.zju.vipa.aix.web.container.api.response;

/**
 * @Date: 2020/6/2 14:05
 * @Author: EricMa
 * @Description: todo:
 */
public abstract class Response {
    int code;//20000  成功
    Object data;

    public Response(int code) {
        this.code = code;
        this.data ="";
    }


    public Response(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
