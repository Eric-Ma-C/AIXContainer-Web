package org.zju.vipa.aix.web.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.zju.vipa.aix.web.container.dubbo.RpcClient;

@SpringBootApplication
public class ContainerWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ContainerWebApplication.class, args);

    }

    //为了打包springboot项目
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
