package org.zju.vipa.aix.web.container.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zju.vipa.aix.container.api.AIXClientCenterService;
import org.zju.vipa.aix.container.api.entity.AixDeviceVO;
import org.zju.vipa.aix.container.api.entity.RunningClient;
import org.zju.vipa.aix.container.common.db.entity.aix.Task;
import org.zju.vipa.aix.container.common.message.Message;
import org.zju.vipa.aix.container.common.utils.JsonUtils;
import org.zju.vipa.aix.web.container.api.constant.TaskAction;
import org.zju.vipa.aix.web.container.api.response.AixListResponse;
import org.zju.vipa.aix.web.container.api.response.AixResponse;
import org.zju.vipa.aix.web.container.api.response.Code;
import org.zju.vipa.aix.web.container.dubbo.RpcClient;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Date: 2020/6/1 21:04
 * @Author: EricMa
 * @Description:
 */
@RestController
@RequestMapping("/aix/client")
public class ClientController {


    private AIXClientCenterService service;

    private Queue<String> realTimelog = new LinkedList<>();

    public void addLog(String log) {
        realTimelog.add(log);
    }

    public ClientController() {
        this.service = RpcClient.getInstance().getService();
    }


    @GetMapping("/active_num")
    public AixResponse getActiveClientNum() {

        int num = service.getActiveClientNum();
        return new AixResponse(Code.SUCCESS, num);
    }

    @GetMapping("/online_num")
    public AixResponse getOnlineClientNum() {
        int num = service.getOnlineClientNum();
        return new AixResponse(Code.SUCCESS, num);
    }

    @GetMapping("/list")
    public AixResponse getClientList() {
        List<RunningClient> clientList = service.getClientList();

        return new AixListResponse(Code.SUCCESS, clientList);
    }
    @GetMapping("/info")
    public AixResponse getClientById(@RequestParam String id) {
        AixDeviceVO vo = service.getDeviceInfoById(id);

        return new AixResponse(Code.SUCCESS, vo);
    }

    @GetMapping("/msg_queue")
    public AixResponse getMessageQueueByToken(@RequestParam String token) {
        List<Message> messageQueue = service.getMessageQueueByToken(token);
        return new AixResponse(Code.SUCCESS, messageQueue);
    }

    @GetMapping("/task-info")
    public AixResponse getTaskByToken(@RequestParam String token) {
        Task task = service.getTaskByToken(token);
        return new AixResponse(Code.SUCCESS, task);
    }

    @GetMapping("/task-logs")
    public AixResponse getTaskLogsByToken(@RequestParam String token) {
        List<String> taskLogList = service.getTaskLogsByToken(token);
        if (taskLogList==null)
            return new AixResponse(Code.SUCCESS);

        StringBuilder sb=new StringBuilder();
        for (String s : taskLogList) {
            sb.append(s);
        }
        return new AixResponse(Code.SUCCESS, sb.toString());
    }


    @GetMapping("/log/start")
    private AixResponse clientLogInit(@RequestParam String token) {
        service.clientLogInit(token);
        return new AixResponse(Code.SUCCESS);

    }

    @GetMapping("/log/stop")
    private AixResponse clientLogStop(@RequestParam String token) {
        service.clientLogStop(token);
        return new AixResponse(Code.SUCCESS);

    }

    @GetMapping("/log/line")
    private AixResponse srverLogReadLine() {
        String str = realTimelog.poll();
//        if (str!=null&&str.length()>0){
//            str=str.replace("\n", "</br>");
//        }
//        System.out.println(str.toCharArray());
        return new AixResponse(Code.SUCCESS, str);
    }


    @PostMapping("/task")
    public AixResponse handleTask(@RequestBody String body) {
        String action = JsonUtils.getValue(body, "action");
        String token = JsonUtils.getValue(body, "token");
        if (TaskAction.STOP.isMatch(action)) {
            service.clientTaskStop(token);
        }

        return new AixResponse(Code.SUCCESS);
    }


}
