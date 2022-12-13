package com.kenbings.shop.shopdockercompose.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.kenbings.shop.shopdockercompose.mbg.mapper")
public class MyBatisConfig {
}