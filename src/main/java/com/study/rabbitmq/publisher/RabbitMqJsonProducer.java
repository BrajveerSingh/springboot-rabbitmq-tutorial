package com.study.rabbitmq.publisher;

import com.study.rabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class RabbitMqJsonProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqJsonProducer.class);
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.json.routing.key}")
    private String jsonRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMqJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonToQueue(final User user) {
        LOGGER.info("User:{}, exchange:{}, routingKey:{}" , user, exchange, jsonRoutingKey);
        rabbitTemplate.convertAndSend(exchange, jsonRoutingKey, user);
        LOGGER.info("User sent to the RabbitMQ Successfully");
    }
}
