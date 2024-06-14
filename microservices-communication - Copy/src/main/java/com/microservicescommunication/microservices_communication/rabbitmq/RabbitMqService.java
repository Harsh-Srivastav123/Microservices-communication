package com.microservicescommunication.microservices_communication.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicescommunication.microservices_communication.common.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqService {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    ObjectMapper objectMapper;

    public void send(Message message) {
        log.info("Message sent from microservice-2 to exchangeBtoA");
        try {
            rabbitTemplate.convertAndSend(RabbitMqConfiguration.EXCHANGE, RabbitMqConfiguration.ROUTING_KEY, objectMapper.writeValueAsString(message));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
