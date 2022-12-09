package com.kenbings.shop.shoprabbitmq.service.impl;

import com.kenbings.shop.shoprabbitmq.common.api.CommonResult;
import com.kenbings.shop.shoprabbitmq.component.CancelOrderSender;
import com.kenbings.shop.shoprabbitmq.dto.OrderParam;
import com.kenbings.shop.shoprabbitmq.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 前台订单管理 Service的实现类
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderService.class);

    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        //TODO 一系列下单操作，这些逻辑可参考完整项目
        LOGGER.info("开始生成订单");
        //下单完成后发送一个延迟消息，用于实现当用户没有付款时取消订单这一功能，注意orderId应该在下单后生成
        Long orderId = 516516161616L;
        sendDelayMessageCancelOrder(orderId);
        return CommonResult.success("下单成功");
    }

    @Override
    public void cancelOrder(Long orderId) {
        //TODO 一系列取消订单操作，这些逻辑可参考完整项目
        LOGGER.info("开始取消订单，订单号为：{}",orderId);
    }

    private void sendDelayMessageCancelOrder(Long orderId) {
        //获取订单超时时间，假设为30秒
        long delayTimes = 30 * 1000;
        //发送延迟消息
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }
}