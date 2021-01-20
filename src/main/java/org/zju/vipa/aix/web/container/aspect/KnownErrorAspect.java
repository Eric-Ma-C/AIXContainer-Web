package org.zju.vipa.aix.web.container.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zju.vipa.aix.container.api.AIXClientCenterService;
import org.zju.vipa.aix.container.common.env.KnownErrorRuntime;
import org.zju.vipa.aix.web.container.api.vo.KnownErrorVO;
import org.zju.vipa.aix.web.container.db.entity.KnownError;
import org.zju.vipa.aix.web.container.dubbo.RpcClient;
import org.zju.vipa.aix.web.container.service.KnownErrorService;

import java.util.ArrayList;
import java.util.List;


/**
 * @Date: 2021/1/20 11:02
 * @Author: EricMa
 * @Description: KnownError更新后通知ErrorParser
 */
@Aspect
@Component
public class KnownErrorAspect {
    private AIXClientCenterService service;
    private final KnownErrorService knownErrorService;

    @Autowired
    public KnownErrorAspect(KnownErrorService knownErrorService) {
        this.knownErrorService = knownErrorService;
        this.service = RpcClient.getInstance().getService();
    }


    /**
     *  定义一个公共的方法，实现服用
     *  拦截KnownErrorService下面的所有方法
     */
    @Pointcut("execution(public * org.zju.vipa.aix.web.container.service.KnownErrorService.update*(..)) || execution(public * org.zju.vipa.aix.web.container.service.KnownErrorService.insert(..))")
    public void refreshRuntimeErrorList() {
        List<KnownError> knownErrorList = knownErrorService.getKnownErrorList();
        List<KnownErrorRuntime> knownErrorRuntimeList=new ArrayList<>();
        for (KnownError error : knownErrorList) {
            knownErrorRuntimeList.add(new KnownErrorRuntime(error.getName(), error.getKey_words(),error.getRepair_cmds()));
        }


        service.refreshRuntimeErrorList(knownErrorRuntimeList);
    }


}
