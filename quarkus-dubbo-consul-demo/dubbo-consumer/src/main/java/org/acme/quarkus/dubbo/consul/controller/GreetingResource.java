package org.acme.quarkus.dubbo.consul.controller;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @Author chris.zhao@shijigroup.com
 * @Date 2020/9/21 5:12 下午
 **/
@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "message", defaultValue="Hello from default")
    String message;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return message;
    }
}