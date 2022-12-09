package com.kenbings.shop.shoprabbitmq.component;

import com.kenbings.shop.shoprabbitmq.enums.QueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 往订单延迟队列(订单消息通知TTL队列，`shop.order.cancel.ttl.queue`)中发送消息
 * 取消订单消息的发出者
 */
@Component
public class CancelOrderSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(CancelOrderSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 给延迟队列发送消息
     * @param orderId 订单号
     * @param delayTime 延迟时间（毫秒）
     */
    public void sendMessage(Long orderId,long delayTime){
        String exchange = QueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange();
        String routingKey = QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRoutingKey();
        amqpTemplate.convertAndSend(exchange, routingKey, orderId, new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        //给消息设置延迟时间，单位毫秒
                        message.getMessageProperties().setExpiration(String.valueOf(delayTime));
                        return message;
                    }
                }
        );
        LOGGER.info("发送延迟消息，订单号为：{}",orderId);
    }
}