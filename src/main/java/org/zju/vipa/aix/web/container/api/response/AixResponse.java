package org.zju.vipa.aix.web.container.api.response;

/**
 * @Date: 2020/6/2 14:06
 * @Author: EricMa
 * @Description: todo:
 */
public class AixResponse extends Response {
    public AixResponse(int code) {
        super(code);
    }

    public AixResponse(int code, Object info) {
        super(code, info);
    }


}
