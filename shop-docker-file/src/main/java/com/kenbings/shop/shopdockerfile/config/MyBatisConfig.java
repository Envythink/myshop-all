package com.kenbings.shop.shopdockerfile.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.kenbings.shop.shopdockerfile.mbg.mapper")
public class MyBatisConfig {
}