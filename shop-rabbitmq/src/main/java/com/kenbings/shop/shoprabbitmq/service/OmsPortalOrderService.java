package com.kenbings.shop.shoprabbitmq.service;

import com.kenbings.shop.shoprabbitmq.common.api.CommonResult;
import com.kenbings.shop.shoprabbitmq.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理 Service
 */
public interface OmsPortalOrderService {
    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}