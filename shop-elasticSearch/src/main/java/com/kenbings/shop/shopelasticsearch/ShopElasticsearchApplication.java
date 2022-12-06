package com.kenbings.shop.shopelasticsearch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.kenbings.shop.shopelasticsearch.mbg.mapper","com.kenbings.shop.shopelasticsearch.dao"})
public class ShopElasticsearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopElasticsearchApplication.class, args);
    }
}