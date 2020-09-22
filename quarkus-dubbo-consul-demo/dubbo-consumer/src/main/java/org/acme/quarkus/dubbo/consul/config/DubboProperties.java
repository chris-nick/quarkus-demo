package org.acme.quarkus.dubbo.consul.config;

import io.quarkus.arc.config.ConfigProperties;
import lombok.Data;

/**
 * @Author chris.zhao@shijigroup.com
 * @Date 2020/9/18 12:46 下午
 **/
@ConfigProperties(prefix = "quarkus.dubbo")
@Data
public class DubboProperties {

    private String name;

    private String registryAddress;

    private Protocol protocol;

    @Data
    public static class Protocol {

        private Integer port;

        private String name = "dubbo";

        private String host;

    }
}
