package org.zju.vipa.aix.web.container.api.response;

/**
 * @Date: 2020/6/2 14:06
 * @Author: EricMa
 * @Description:
 */
public class AixResponse extends Response {
    public AixResponse(Code code) {
        super(code);
    }

    public AixResponse(Code code, Object info) {
        super(code, info);
    }


}
