package com.kenbings.shop.shoprabbitmq.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.kenbings.shop.shoprabbitmq.mbg.mapper")
public class MyBatisConfig {
}