package org.zju.vipa.aix.web.container.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zju.vipa.aix.container.common.utils.JsonUtils;
import org.zju.vipa.aix.web.container.api.response.AixResponse;
import org.zju.vipa.aix.web.container.api.response.Code;
import org.zju.vipa.aix.web.container.api.vo.SourceVO;
import org.zju.vipa.aix.web.container.service.SourceService;

import java.util.List;

/**
 * @Date: 2021/2/3 15:47
 * @Author: EricMa
 * @Description:
 */
@RestController
@RequestMapping("/aix/source")
public class SourceController {
    private final SourceService sourceService;

    @Autowired
    public SourceController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    @GetMapping("/pip_count")
    public AixResponse getPipSourceCount() {

        Integer num = sourceService.getPipSourceCount();

        return new AixResponse(Code.SUCCESS, num);
    }
    @GetMapping("/apt_count")
    public AixResponse getAptSourceCount() {

        Integer num = sourceService.getAptSourceCount();

        return new AixResponse(Code.SUCCESS, num);
    }

    @GetMapping("/pip_page")
    public AixResponse getPipSourceListByPage(@RequestParam int page, @RequestParam int countPerPage) {

        List<SourceVO> list = sourceService.getPipSourceListByPage(page, countPerPage);
        return new AixResponse(Code.SUCCESS, list);
    }
    @GetMapping("/apt_page")
    public AixResponse getAptSourceListByPage(@RequestParam int page, @RequestParam int countPerPage) {

        List<SourceVO> list = sourceService.getAptSourceListByPage(page, countPerPage);
        return new AixResponse(Code.SUCCESS, list);
    }

    @PostMapping("/name")
    public AixResponse updateNameById(@RequestBody String body) {
        String id = JsonUtils.getValue(body, "id");
        String newName = JsonUtils.getValue(body, "newName");

        try {

            boolean ok = sourceService.updateNameById(id, newName);

            return ok ? new AixResponse(Code.SUCCESS) : new AixResponse(Code.FAILED, "修改失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new AixResponse(Code.EXCEPTION, e.getMessage());
        }

    }

    @PostMapping("/url")
    public AixResponse updateUrlById(@RequestBody String body) {
        String id = JsonUtils.getValue(body, "id");
        String url = JsonUtils.getValue(body, "newUrl");

        try {

            boolean ok = sourceService.updateUrlById(id, url);

            return ok ? new AixResponse(Code.SUCCESS) : new AixResponse(Code.FAILED, "修改失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new AixResponse(Code.EXCEPTION, e.getMessage());
        }

    }


    @PostMapping("/insert")
    public AixResponse insert(@RequestBody String body) {
        String name = JsonUtils.getValue(body, "name");
        String url = JsonUtils.getValue(body, "url");
        String type = JsonUtils.getValue(body, "type");

        try {

            boolean ok = sourceService.insert(name, url,type);

            return ok ? new AixResponse(Code.SUCCESS) : new AixResponse(Code.FAILED, "新建失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new AixResponse(Code.EXCEPTION, e.getMessage());
        }

    }

    @PostMapping("/delete")
    public AixResponse deleteById(@RequestBody String body) {
        String id = JsonUtils.getValue(body, "id");

        try {

            boolean ok = sourceService.deleteById(id);

            return ok ? new AixResponse(Code.SUCCESS) : new AixResponse(Code.FAILED, "删除失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new AixResponse(Code.EXCEPTION, e.getMessage());
        }

    }
}
