package org.acme.quarkus.dubbo.consul.controller;

import org.acme.quarkus.dubbo.consul.model.Goods;
import org.acme.quarkus.dubbo.consul.service.OrderService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
@Path("/open/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderController {


    @Inject
    OrderService orderService;

    @GET
    @Path("/id/{goodsId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Goods getGoods(@PathParam long goodsId){
        Goods goods =  orderService.get(goodsId);
        goods.setTitle("consumer 给你打8折：" + goods.getTitle() + ": " + goods.getPrice() * 0.8);
        return goods;
    }

    @GET
    @Path("/hello")
    public String hello(){

        return orderService.sayHello();
    }

}
