package com.kenbings.shop.shopmongodb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.kenbings.shop.shopmongodb.mbg.mapper","com.kenbings.shop.shopmongodb.dao"})
public class ShopMongoDBApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopMongoDBApplication.class, args);
    }
}