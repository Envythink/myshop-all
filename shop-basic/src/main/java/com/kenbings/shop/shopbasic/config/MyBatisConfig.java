package com.kenbings.shop.shopbasic.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.kenbings.shop.shopbasic.mbg.mapper")
public class MyBatisConfig {
}