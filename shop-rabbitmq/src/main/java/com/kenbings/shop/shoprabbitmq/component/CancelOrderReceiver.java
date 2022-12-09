package com.kenbings.shop.shoprabbitmq.component;

import com.kenbings.shop.shoprabbitmq.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 处理取消订单消息
 */
@Component
@RabbitListener(queues = "shop.order.cancel.queue")
public class CancelOrderReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);

    @Autowired
    private OmsPortalOrderService portalOrderService;

    @RabbitHandler
    public void handle(Long orderId){
        LOGGER.info("收到延迟消息，订单号为：{}",orderId);
        portalOrderService.cancelOrder(orderId);
    }
}