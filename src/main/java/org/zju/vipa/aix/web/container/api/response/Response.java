package org.zju.vipa.aix.web.container.api.response;

/**
 * @Date: 2020/6/2 14:05
 * @Author: EricMa
 * @Description: todo:
 */
public abstract class Response {
    Code code;//20000  成功
    Object data;

    public Response(Code code) {
        this.code = code;
        this.data ="";
    }


    public Response(Code code, Object data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code.getValue();
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
