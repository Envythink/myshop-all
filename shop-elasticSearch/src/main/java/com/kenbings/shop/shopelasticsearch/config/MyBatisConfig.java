package com.kenbings.shop.shopelasticsearch.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.kenbings.shop.shopelasticsearch.mbg.mapper")
public class MyBatisConfig {
}