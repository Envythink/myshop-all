package com.kenbings.shop.shoprabbitmq.nosql.mongodb.repository;

import com.kenbings.shop.shoprabbitmq.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 会员商品浏览历史记录Repository
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {
    /**
     * 根据会员id按照时间倒序获取商品浏览历史记录
     * @param memberId 会员id
     * @return 商品浏览历史记录
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}