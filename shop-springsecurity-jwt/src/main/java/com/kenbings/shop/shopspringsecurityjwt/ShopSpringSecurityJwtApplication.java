package com.kenbings.shop.shopspringsecurityjwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.kenbings.shop.shopspringsecurityjwt.mbg.mapper","com.kenbings.shop.shopspringsecurityjwt.dao"})
public class ShopSpringSecurityJwtApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopSpringSecurityJwtApplication.class, args);
    }
}