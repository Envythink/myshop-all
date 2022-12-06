package com.kenbings.shop.shopelasticsearch.dao;

import com.kenbings.shop.shopelasticsearch.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 搜索系统中商品管理自定义的Dao
 */
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}