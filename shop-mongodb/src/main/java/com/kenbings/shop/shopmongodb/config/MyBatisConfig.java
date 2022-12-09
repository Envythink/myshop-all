package com.kenbings.shop.shopmongodb.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.kenbings.shop.shopmongodb.mbg.mapper")
public class MyBatisConfig {
}