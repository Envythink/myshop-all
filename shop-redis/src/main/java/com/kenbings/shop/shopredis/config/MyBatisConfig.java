package com.kenbings.shop.shopredis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.kenbings.shop.shopredis.mbg.mapper")
public class MyBatisConfig {
}