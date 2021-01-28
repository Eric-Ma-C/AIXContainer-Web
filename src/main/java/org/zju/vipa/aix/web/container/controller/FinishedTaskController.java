package org.zju.vipa.aix.web.container.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zju.vipa.aix.container.common.utils.JsonUtils;
import org.zju.vipa.aix.web.container.api.response.AixResponse;
import org.zju.vipa.aix.web.container.api.response.Code;
import org.zju.vipa.aix.web.container.api.vo.FinishedTaskVO;
import org.zju.vipa.aix.web.container.service.FinishedTaskService;

import java.util.List;

/**
 * @Date: 2021/1/24 13:46
 * @Author: EricMa
 * @Description: :
 */
@RestController
@RequestMapping("/aix/finished_task")
public class FinishedTaskController {
    private final FinishedTaskService finishedTaskService;

    @Autowired
    public FinishedTaskController(FinishedTaskService finishedTaskService) {
        this.finishedTaskService = finishedTaskService;
    }

    @GetMapping("/count")
    public AixResponse getFinishedTaskCount() {

        Integer num = finishedTaskService.getFinishedTaskCount();

        return new AixResponse(Code.SUCCESS, num);
    }

    @GetMapping("/page")
    public AixResponse getFinishedTaskListByPage(@RequestParam int page, @RequestParam int countPerPage) {

        List<FinishedTaskVO> list = finishedTaskService.getFinishedTaskListByPage(page, countPerPage);
        return new AixResponse(Code.SUCCESS, list);
    }

    @PostMapping("/delete")
    public AixResponse deleteById(@RequestBody String body) {
        String id = JsonUtils.getValue(body, "id");

        try {

            boolean ok = finishedTaskService.deleteById(id);

            return ok ? new AixResponse(Code.SUCCESS) : new AixResponse(Code.FAILED, "删除失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new AixResponse(Code.EXCEPTION, e.getMessage());
        }

    }
}
