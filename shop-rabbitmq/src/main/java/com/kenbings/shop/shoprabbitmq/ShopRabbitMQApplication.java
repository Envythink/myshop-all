package com.kenbings.shop.shoprabbitmq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.kenbings.shop.shoprabbitmq.mbg.mapper","com.kenbings.shop.shoprabbitmq.dao"})
public class ShopRabbitMQApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopRabbitMQApplication.class, args);
    }
}