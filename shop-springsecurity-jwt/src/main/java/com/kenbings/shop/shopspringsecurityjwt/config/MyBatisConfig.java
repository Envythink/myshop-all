package com.kenbings.shop.shopspringsecurityjwt.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.kenbings.shop.shopspringsecurityjwt.mbg.mapper")
public class MyBatisConfig {
}