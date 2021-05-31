package org.zju.vipa.aix.web.container.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zju.vipa.aix.container.api.AIXClientCenterService;
import org.zju.vipa.aix.web.container.dubbo.RpcClient;

import org.zju.vipa.aix.web.container.service.SourceService;


/**
 * @Date: 2021/5/18 19:27
 * @Author: EricMa
 * @Description: Source修改后rpc调用通知容器管理模块
 */
@Aspect
@Component
public class SourceAspect {
    private static Logger logger= LoggerFactory.getLogger(SourceAspect.class);
    private AIXClientCenterService service;
    private final SourceService sourceService;

    @Autowired
    public SourceAspect(SourceService sourceService) {
        this.sourceService = sourceService;
        this.service = RpcClient.getInstance().getService();
    }


    /**
     *  定义一个公共的方法，实现复用
     *  拦截KnownErrorService下面的所有方法
     */
    @Pointcut("execution(public * org.zju.vipa.aix.web.container.service.SourceService.update*(..))" +
        " || execution(public * org.zju.vipa.aix.web.container.service.SourceService.insert(..))" +
        "|| execution(public * org.zju.vipa.aix.web.container.service.SourceService.delete*(..))")
    public void refreshSourceList() {
    }

    @After("refreshSourceList()")
    public void doAfterRefreshSource() {
        logger.info("doAfterRefreshSource:");
        service.refreshSource();
    }
}

