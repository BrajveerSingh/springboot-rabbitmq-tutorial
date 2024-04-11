package com.study.rabbitmq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {
private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqProducer.class);
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendToQueue(String message) {
        LOGGER.info("Message:{}, exchange:{}, routingKey:{}" , message, exchange, routingKey);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        LOGGER.info("Message sent to the RabbitMQ Successfully");
    }
}
