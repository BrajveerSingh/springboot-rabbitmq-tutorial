package com.study.rabbitmq.consumer;

import com.study.rabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqJsonConsumer.class);

    @RabbitListener(queues = "${rabbitmq.json.queue.name}")
    public void consumeJsonMessage(final User message) {
        LOGGER.info("Message consumed: {}", message);

    }
}
