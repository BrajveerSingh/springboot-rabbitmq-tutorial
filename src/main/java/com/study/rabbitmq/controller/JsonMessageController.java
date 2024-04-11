package com.study.rabbitmq.controller;

import com.study.rabbitmq.dto.User;
import com.study.rabbitmq.publisher.RabbitMqJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/json/messages")
public class JsonMessageController {
    private final RabbitMqJsonProducer rabbitMqJsonProducer;

    public JsonMessageController(RabbitMqJsonProducer rabbitMqJsonProducer) {
        this.rabbitMqJsonProducer = rabbitMqJsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishJsonMessage(@RequestBody final User user) {
        rabbitMqJsonProducer.sendJsonToQueue(user);
        return ResponseEntity.ok("Json Message sent to the RabbitMQ Successfully");
    }
}
