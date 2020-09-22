package org.acme.quarkus.dubbo.consul.service;

import org.acme.quarkus.dubbo.consul.model.Goods;


public interface OrderService {

    Goods save(Goods goods);

    Goods get(long goodsId);

    String sayHello();
}
