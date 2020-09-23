package org.zju.vipa.aix.web.container.api.response;

import org.zju.vipa.aix.web.container.api.entity.ListWithTotal;

import java.util.List;

/**
 * @Date: 2020/6/9 15:30
 * @Author: EricMa
 * @Description: todo:
 */
public class AixListResponse extends AixResponse {

    public AixListResponse(int code) {
        super(code);
    }

    public AixListResponse(int code, List<?> info) {
        super(code, new ListWithTotal(info));

    }
}
