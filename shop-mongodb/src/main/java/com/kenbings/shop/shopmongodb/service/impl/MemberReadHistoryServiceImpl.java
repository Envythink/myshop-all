package com.kenbings.shop.shopmongodb.service.impl;

import com.kenbings.shop.shopmongodb.nosql.mongodb.document.MemberReadHistory;
import com.kenbings.shop.shopmongodb.nosql.mongodb.repository.MemberReadHistoryRepository;
import com.kenbings.shop.shopmongodb.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 会员浏览商品历史记录管理Service的实现类
 */
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;

    @Override
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> deleteMemberReadHistoryLists = new ArrayList<>();
        for(String id:ids){
            MemberReadHistory memberReadHistory = new MemberReadHistory();
            memberReadHistory.setId(id);
            deleteMemberReadHistoryLists.add(memberReadHistory);
        }
        memberReadHistoryRepository.deleteAll(deleteMemberReadHistoryLists);
        return deleteMemberReadHistoryLists.size();
    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}