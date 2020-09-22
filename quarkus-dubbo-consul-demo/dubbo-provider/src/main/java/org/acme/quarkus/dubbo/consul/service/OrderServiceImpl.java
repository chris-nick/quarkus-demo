package org.acme.quarkus.dubbo.consul.service;

import org.acme.quarkus.dubbo.consul.model.Goods;

import javax.enterprise.context.Dependent;

@Dependent
public class OrderServiceImpl implements OrderService {

    @Override
    public Goods save(Goods goods) {
        goods.setId(100L);
        return goods;
    }

    @Override
    public Goods get(long goodsId) {
        Goods goods = new Goods();

        goods.setId(goodsId);
        goods.setPrice(12111);
        goods.setStock(20);
        goods.setTitle("腾讯黑鲨手机 M100");
        return goods;
    }

    @Override
    public String sayHello() {
        return "世界，你好。 Hello world";
    }
}
