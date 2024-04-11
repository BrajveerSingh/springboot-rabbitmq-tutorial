package com.study.rabbitmq.controller;

import com.study.rabbitmq.publisher.RabbitMqProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final RabbitMqProducer rabbitMqProducer;

    public MessageController(RabbitMqProducer rabbitMqProducer) {
        this.rabbitMqProducer = rabbitMqProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("message") final String message) {
        rabbitMqProducer.sendToQueue(message);
        return ResponseEntity.ok("Message sent to the RabbitMQ Successfully");
    }
}
