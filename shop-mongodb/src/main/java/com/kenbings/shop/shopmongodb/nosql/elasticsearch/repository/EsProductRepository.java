package com.kenbings.shop.shopmongodb.nosql.elasticsearch.repository;

import com.kenbings.shop.shopmongodb.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsProductRepository extends ElasticsearchRepository<EsProduct,Long> {
    /**
     * 搜索查询
     * @param name 商品名称
     * @param subTitle 商品副标题
     * @param keywords 商品关键字
     * @param page 分页信息
     * @return 搜索结果
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);
}