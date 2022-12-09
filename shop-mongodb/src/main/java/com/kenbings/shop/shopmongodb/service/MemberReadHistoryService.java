package com.kenbings.shop.shopmongodb.service;

import com.kenbings.shop.shopmongodb.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * 会员浏览商品历史记录管理 Service
 */
public interface MemberReadHistoryService {
    /**
     * 生成浏览历史记录
     * @param memberReadHistory 浏览历史记录信息
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览历史记录
     * @param ids 浏览历史记录id
     */
    int delete(List<String> ids);

    /**
     * 获取指定会员的浏览历史记录
     * @param memberId 会员id
     */
    List<MemberReadHistory> list(Long memberId);
}