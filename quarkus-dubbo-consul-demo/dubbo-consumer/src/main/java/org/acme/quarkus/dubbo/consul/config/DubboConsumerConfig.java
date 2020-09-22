package org.acme.quarkus.dubbo.consul.config;

import org.acme.quarkus.dubbo.consul.service.OrderService;
import org.apache.dubbo.config.*;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * @Author chris.zhao@shijigroup.com
 * @Date 2020/9/18 11:43 上午
 **/
@Dependent
public class DubboConsumerConfig {

    @Inject
    DubboProperties dubboProperties;


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

    @Produces
    public OrderService orderService() {

        return this.referenceService(OrderService.class);
    }

    private <T> T referenceService(Class<T> clazz) {
            ReferenceConfig<Object> reference = new ReferenceConfig<>();
            reference.setApplication(applicationConfig());
            reference.setRegistry(registryConfig());
            reference.setInterface(clazz);
            reference.setVersion("1.0.0");
            reference.setCheck(false);
            reference.setProtocol("dubbo");
            return (T) reference.get();

    }


}
