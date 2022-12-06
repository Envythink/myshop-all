package com.kenbings.shop.shopelasticsearch.service;

import com.kenbings.shop.shopelasticsearch.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * EsProduct搜索的Service
 */
public interface EsProductService {
    /**
     * 从数据中导入所有商品到ES
     * @return 导入的文档数
     */
    int importAll();

    /**
     * 根据id删除ES中的商品
     * @param id 商品id
     */
    void delete(Long id);

    /**
     * 在ES中创建指定id的商品文档信息
     * @param id 商品id
     */
    EsProduct create(Long id);

    /**
     * 根据id批量删除ES中的商品
     * @param ids 商品id
     */
    void delete(List<Long> ids);

    /**
     * 根据关键字搜索商品信息
     * @param keyword 关键字
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @return
     */
    Page<EsProduct> search(String keyword,Integer pageNum, Integer pageSize);
}