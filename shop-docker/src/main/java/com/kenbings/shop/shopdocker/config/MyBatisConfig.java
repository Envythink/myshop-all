package com.kenbings.shop.shopdocker.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.kenbings.shop.shopdocker.mbg.mapper")
public class MyBatisConfig {
}