package com.oyeks.oyeks.controller;

import com.oyeks.oyeks.kafka.JsonKafkaProducer;
import com.oyeks.oyeks.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("publish")
    public ResponseEntity<String> publish (@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("JsonMessage sent to kafka topic");
    }
}
