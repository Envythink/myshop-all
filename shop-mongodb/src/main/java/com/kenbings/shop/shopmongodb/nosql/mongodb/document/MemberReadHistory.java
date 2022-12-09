package com.kenbings.shop.shopmongodb.nosql.mongodb.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 用户商品浏览历史记录文档对象
 */
@Data
@Document
public class MemberReadHistory {
    @Id
    private String id;
    /**
     * 用户id
     */
    @Indexed
    private Long memberId;
    /**
     * 用户昵称
     */
    private String memberNickname;
    /**
     * 用户头像
     */
    private String memberIcon;
    /**
     * 商品id
     */
    @Indexed
    private Long productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品图片
     */
    private String productPic;
    /**
     * 商品副标题
     */
    private String productSubTitle;
    /**
     * 商品价格
     */
    private String productPrice;
    /**
     * 浏览时间
     */
    private Date createTime;
}