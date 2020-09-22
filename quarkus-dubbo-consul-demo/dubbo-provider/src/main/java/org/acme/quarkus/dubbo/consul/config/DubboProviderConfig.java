package org.acme.quarkus.dubbo.consul.config;

import org.acme.quarkus.dubbo.consul.service.OrderService;
import io.quarkus.runtime.StartupEvent;
import org.apache.dubbo.config.*;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * @Author chris.zhao@shijigroup.com
 * @Date 2020/9/18 11:43 上午
 **/
@Dependent
public class DubboProviderConfig {

    @Inject
    DubboProperties dubboProperties;

    @Inject
    OrderService orderService;

    private ApplicationConfig applicationConfig(){
        ApplicationConfig config = new ApplicationConfig();
        config.setName(dubboProperties.getName());
        config.setVersion("1.0.0");
        config.setQosEnable(false);
        return config;
    }

    private RegistryConfig registryConfig(){
        RegistryConfig config = new RegistryConfig();
        config.setAddress(dubboProperties.getRegistryAddress());
        config.setVersion("1.0.0");
        config.setCheck(false);
        config.setProtocol("consul");
        return config;
    }

    private ProtocolConfig protocolConfig(){
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName(dubboProperties.getProtocol().getName());
        protocol.setPort(dubboProperties.getProtocol().getPort());
        protocol.setHost(dubboProperties.getProtocol().getHost());
        return protocol;
    }


    public void onStart(@Observes StartupEvent event){
        ServiceConfig serviceConfig = new ServiceConfig();
        serviceConfig.setProtocol(protocolConfig());
        serviceConfig.setRegistry(registryConfig());
        serviceConfig.setApplication(applicationConfig());
        serviceConfig.setInterface(OrderService.class);
        serviceConfig.setRef(orderService);
        serviceConfig.setVersion("1.0.0");
        serviceConfig.export();
    }
}
