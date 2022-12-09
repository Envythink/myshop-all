package com.kenbings.shop.shoprabbitmq.config;

import com.kenbings.shop.shoprabbitmq.enums.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息队列配置类
 */
@Configuration
public class RabbitMQConfig {
    /**
     * 订单消息实际消费队列所绑定的交换机
     */
    @Bean
    public DirectExchange orderDirectExchange(){
        return (DirectExchange) ExchangeBuilder.directExchange(QueueEnum.QUEUE_ORDER_CANCEL.getExchange()).durable(true).build();
    }

    /**
     * 订单延迟队列所绑定的交换机
     */
    @Bean
    public DirectExchange orderTTLDirectExchange(){
        return (DirectExchange) ExchangeBuilder.directExchange(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange()).durable(true).build();
    }

    /**
     * 订单消息实际消费队列
     */
    @Bean
    public Queue orderQueue(){
        return new Queue(QueueEnum.QUEUE_ORDER_CANCEL.getQueue());
    }

    /**
     * 订单延迟消息队列（死信队列）
     */
    @Bean
    public Queue orderTTLQueue(){
        return QueueBuilder.durable(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getQueue())
                .withArgument("x-dead-letter-exchange", QueueEnum.QUEUE_ORDER_CANCEL.getExchange()) //消息过期后转到的交换机
        .withArgument("x-dead-letter-routing-key", QueueEnum.QUEUE_ORDER_CANCEL.getRoutingKey()) //消息过期后转发的路由键
        .build();
    }

    /**
     * 将正常订单队列绑定到交换机
     */
    @Bean
    public Binding orderBinding(DirectExchange orderDirectExchange,Queue orderQueue){
        return BindingBuilder.bind(orderQueue).to(orderDirectExchange).with(QueueEnum.QUEUE_ORDER_CANCEL.getRoutingKey());
    }

    /**
     * 将订单延迟队列绑定到交换机
     */
    @Bean
    public Binding orderTTLBinding(DirectExchange orderTTLDirectExchange,Queue orderTTLQueue){
        return BindingBuilder.bind(orderTTLQueue).to(orderTTLDirectExchange).with(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRoutingKey());
    }
}