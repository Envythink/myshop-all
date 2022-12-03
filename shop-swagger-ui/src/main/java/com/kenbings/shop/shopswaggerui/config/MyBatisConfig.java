package com.kenbings.shop.shopswaggerui.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.kenbings.shop.shopswaggerui.mbg.mapper")
public class MyBatisConfig {
}