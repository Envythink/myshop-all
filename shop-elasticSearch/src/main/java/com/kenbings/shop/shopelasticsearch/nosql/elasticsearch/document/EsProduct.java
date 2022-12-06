package com.kenbings.shop.shopelasticsearch.nosql.elasticsearch.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 搜索中的商品信息
 */
@Data
@Document(indexName = "pms", type = "product",shards = 1,replicas = 0)
public class EsProduct implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    private Long id;
    private Long brandId;
    private Long productCategoryId;

    /**
     * 货号
     */
    @Field(type = FieldType.Keyword)
    private String productSn;

    /**
     * 品牌名称
     */
    @Field(type = FieldType.Keyword)
    private String brandName;

    /**
     * 商品分类名称
     */
    @Field(type = FieldType.Keyword)
    private String productCategoryName;

    /**
     * 商品名称
     */
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String name;

    /**
     * 副标题
     */
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String subTitle;

    /**
     * 关键字
     */
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String keywords;

    private String pic;
    private BigDecimal price;
    private Integer sale;
    private Integer newStatus;
    private Integer recommendStatus;
    private Integer stock;
    private Integer promotionType;
    private Integer sort;

    /**
     * 嵌套类型，商品属性列表
     */
    @Field(type =FieldType.Nested)
    private List<EsProductAttributeValue> attrValueList;
}