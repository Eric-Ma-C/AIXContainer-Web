package org.zju.vipa.aix.web.container.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zju.vipa.aix.container.api.entity.AixDeviceVO;
import org.zju.vipa.aix.container.common.utils.JsonUtils;
import org.zju.vipa.aix.web.container.api.response.AixResponse;
import org.zju.vipa.aix.web.container.api.response.Code;
import org.zju.vipa.aix.web.container.api.vo.KnownErrorVO;
import org.zju.vipa.aix.web.container.dubbo.RpcClient;
import org.zju.vipa.aix.web.container.service.KnownErrorService;

import java.util.List;

/**
 * @Date: 2021/1/19 14:44
 * @Author: EricMa
 * @Description:
 */
@RestController
@RequestMapping("/aix/known_error")
public class KnownErrorController {
    private final KnownErrorService knownErrorService;

    @Autowired
    public KnownErrorController(KnownErrorService knownErrorService) {
        this.knownErrorService = knownErrorService;
    }

    @GetMapping("/count")
    public AixResponse getKnownErrorCount() {

        Integer num = knownErrorService.getKnownErrorCount();

        return new AixResponse(Code.SUCCESS, num);
    }

    @GetMapping("/page")
    public AixResponse getKnownErrorListByPage(@RequestParam int page, @RequestParam int countPerPage) {

        List<KnownErrorVO> list = knownErrorService.getKnownErrorListByPage(page, countPerPage);
        return new AixResponse(Code.SUCCESS, list);
    }

    @PostMapping("/name")
    public AixResponse updateNameById(@RequestBody String body) {
        String id = JsonUtils.getValue(body, "id");
        String newName = JsonUtils.getValue(body, "newName");

        try {

            boolean ok = knownErrorService.updateNameById(id, newName);

            return ok ? new AixResponse(Code.SUCCESS) : new AixResponse(Code.FAILED, "修改失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new AixResponse(Code.EXCEPTION, e.getMessage());
        }

    }

    @PostMapping("/keywords")
    public AixResponse updateKeywordsById(@RequestBody String body) {
        String id = JsonUtils.getValue(body, "id");
        String keywords = JsonUtils.getValue(body, "newKeywords");

        try {

            boolean ok = knownErrorService.updateKeywordsById(id, keywords);

            return ok ? new AixResponse(Code.SUCCESS) : new AixResponse(Code.FAILED, "修改失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new AixResponse(Code.EXCEPTION, e.getMessage());
        }

    }

    @PostMapping("/repair_cmds")
    public AixResponse updateRepairCmdsById(@RequestBody String body) {
        String id = JsonUtils.getValue(body, "id");
        String repairCmds = JsonUtils.getValue(body, "newRepairCmds");

        try {

            boolean ok = knownErrorService.updateRepairCmdsById(id, repairCmds);

            return ok ? new AixResponse(Code.SUCCESS) : new AixResponse(Code.FAILED, "修改失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new AixResponse(Code.EXCEPTION, e.getMessage());
        }

    }

    @PostMapping("/insert")
    public AixResponse insert(@RequestBody String body) {
        String name = JsonUtils.getValue(body, "name");
        String keywords = JsonUtils.getValue(body, "keywords");
        String repairCmds = JsonUtils.getValue(body, "repairCmds");

        try {

            boolean ok = knownErrorService.insert(name, keywords,repairCmds);

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

            boolean ok = knownErrorService.deleteById(id);

            return ok ? new AixResponse(Code.SUCCESS) : new AixResponse(Code.FAILED, "删除失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new AixResponse(Code.EXCEPTION, e.getMessage());
        }

    }
}
