package com.kenbings.shop.shopmongodb.dao;

import com.kenbings.shop.shopmongodb.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 搜索系统中商品管理自定义的Dao
 */
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}