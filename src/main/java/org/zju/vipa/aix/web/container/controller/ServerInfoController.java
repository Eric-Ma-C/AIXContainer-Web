package org.zju.vipa.aix.web.container.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zju.vipa.aix.container.api.AIXClientCenterService;
import org.zju.vipa.aix.web.container.api.response.AixResponse;
import org.zju.vipa.aix.web.container.api.response.Code;
import org.zju.vipa.aix.web.container.dubbo.RpcClient;

/**
 * @Date: 2020/6/3 16:26
 * @Author: EricMa
 * @Description:
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/aix/server")
public class ServerInfoController {
    private AIXClientCenterService service;

    public ServerInfoController() {
        this.service = RpcClient.getInstance().getService();
    }

    @GetMapping("/log/start")
    private AixResponse srverLogInit(){

        service.serverLogInit();
        return new AixResponse(Code.SUCCESS);

    }
    @GetMapping("/log/stop")
    private AixResponse srverLogStop(){

        service.serverLogStop();
        return new AixResponse(Code.SUCCESS);

    }
    @GetMapping("/log/line")
    private AixResponse srverLogReadLine(){
        String str=service.serverLogReadToEnd();
//        if (str!=null&&str.length()>0){
//            str=str.replace("\n", "</br>");
//        }
//        System.out.println(str.toCharArray());
        return new AixResponse(Code.SUCCESS,str);
    }
}
