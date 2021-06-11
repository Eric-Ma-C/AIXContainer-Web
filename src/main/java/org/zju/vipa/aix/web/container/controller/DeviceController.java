package org.zju.vipa.aix.web.container.controller;

import org.springframework.web.bind.annotation.*;
import org.zju.vipa.aix.container.api.AIXClientCenterService;
import org.zju.vipa.aix.container.api.entity.AixDeviceVO;
import org.zju.vipa.aix.container.common.utils.JsonUtils;
import org.zju.vipa.aix.web.container.api.constant.TaskAction;
import org.zju.vipa.aix.web.container.api.response.AixResponse;
import org.zju.vipa.aix.web.container.api.response.Code;
import org.zju.vipa.aix.web.container.dubbo.RpcClient;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Date: 2021/1/12 20:09
 * @Author: EricMa
 * @Description: 注册设备管理
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/aix/device")
public class DeviceController {
    private AIXClientCenterService service;

    public DeviceController() {
        this.service = RpcClient.getInstance().getService();
    }

    @GetMapping("/count")
    public AixResponse getDeviceCount() {

        int num = service.getClientCount();
        return new AixResponse(Code.SUCCESS, num);
    }

    @GetMapping("/page")
    public AixResponse getClientListByPage(@RequestParam int page, @RequestParam int countPerPage) {

        List<AixDeviceVO> list = service.getClientListByPage(page, countPerPage);
        return new AixResponse(Code.SUCCESS, list);
    }

    @PostMapping("/name")
    public AixResponse updateDeviceNameById(@RequestBody String body) {
        String id = JsonUtils.getValue(body, "id");
        String newName = JsonUtils.getValue(body, "newName");

        try {

            boolean ok = service.updateDeviceNameById(id, newName);

            return ok ? new AixResponse(Code.SUCCESS) : new AixResponse(Code.FAILED,"修改失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new AixResponse(Code.EXCEPTION, e.getMessage());
        }

    }

    @PostMapping("/info")
    public AixResponse updateDevicInfoById(@RequestBody String body) {
        String id = JsonUtils.getValue(body, "id");
        String newInfo = JsonUtils.getValue(body, "info");

        try {

            boolean ok = service.updateDeviceInfoById(id, newInfo);

            return ok ? new AixResponse(Code.SUCCESS) : new AixResponse(Code.FAILED,"修改失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new AixResponse(Code.EXCEPTION, e.getMessage());
        }

    }
}
