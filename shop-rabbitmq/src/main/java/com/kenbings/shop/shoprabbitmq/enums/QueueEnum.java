package com.kenbings.shop.shoprabbitmq.enums;

import lombok.Getter;

/**
 * 消息队列枚举类
 */
@Getter
public enum QueueEnum {
    /**
     * 订单取消通知队列
     */
    QUEUE_ORDER_CANCEL("shop.order.direct.exchange","shop.order.cancel.queue","shop.order.cancel.key"),
    /**
     * 订单消息通知TTL队列
     */
    QUEUE_TTL_ORDER_CANCEL("shop.order.direct.ttl.exchange","shop.order.cancel.ttl.queue","shop.order.cancel.ttl.key");
    /**
     * 交换机
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String queue;
    /**
     * 路由键
     */
    private String routingKey;

    QueueEnum(String exchange, String queue, String routingKey){
        this.exchange = exchange;
        this.queue = queue;
        this.routingKey = routingKey;
    }
}