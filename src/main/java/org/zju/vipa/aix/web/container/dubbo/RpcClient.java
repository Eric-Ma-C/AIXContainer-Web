package org.zju.vipa.aix.web.container.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;

import org.zju.vipa.aix.container.api.AIXClientCenterService;
import org.zju.vipa.aix.container.common.config.NetworkConfig;
import org.zju.vipa.aix.container.common.exception.AIXBaseException;
import org.zju.vipa.aix.container.common.exception.ExceptionCodeEnum;
import org.zju.vipa.aix.web.container.util.PropertyUtils;


/**
 * @Date: 2020/6/2 15:58
 * @Author: EricMa
 * @Description: 基于dubbo的rpc客户端
 */
public class RpcClient {
    /**
     * 服务实现
     */
    private AIXClientCenterService service;
    /**
     * 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
     */
    private ReferenceConfig<AIXClientCenterService> referenceConfig;

    private static class RpcClientHolder {
        private static final RpcClient INSTANCE = new RpcClient();
    }

    private RpcClient() {
        if (RpcClientHolder.INSTANCE != null) {
            throw new AIXBaseException(ExceptionCodeEnum.SINGLETON_MULTI_INSTANCE);
        }
    }

    public static RpcClient getInstance() {
        return RpcClientHolder.INSTANCE;
    }

    /** 启动dubbo */
    private void start() {


        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("AIX-Consumer");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
//        registry.setAddress("zookeeper://127.0.0.1:2181");
        registry.setAddress(PropertyUtils.getProperty("application.properties","zk.server.url","zookeeper://120.79.221.129:2181"));


        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
        // 引用远程服务
        referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(application);
        // 多个注册中心可以用setRegistries()
        referenceConfig.setRegistry(registry);
        referenceConfig.setInterface(AIXClientCenterService.class);
        referenceConfig.setVersion("1.0.0");
        /** 用于区分不同的dubbo服务 */
        referenceConfig.setGroup(PropertyUtils.getProperty("application.properties","dubbo.consumer.group","default-group"));


        // 和本地bean一样使用xxxService
        // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        service = referenceConfig.get();

        if (service != null) {
//            int c = service.getOnlineNum();
//            System.out.println(c);
        } else {
            System.out.println("service is null!");
        }

    }


    public AIXClientCenterService getService() {
        if (service==null) {
            start();
        }
        return service;
    }
}
