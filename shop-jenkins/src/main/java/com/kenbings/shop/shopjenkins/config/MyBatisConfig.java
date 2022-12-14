package com.kenbings.shop.shopjenkins.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.kenbings.shop.shopjenkins.mbg.mapper")
public class MyBatisConfig {
}