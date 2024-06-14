package com.microservicescommunication.microservices_communication.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicescommunication.microservices_communication.common.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
public class RabbitMqListener {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    SimpMessageSendingOperations messagingTemplate;

    @RabbitListener(queues = "queueB")
    public void listenQueueAtoB(String value) {
        log.info("Message received in microservice-1 on queueAtoB");
        log.info(value);

        Message message;
        try {
            message = mapper.readValue(value, Message.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        messagingTemplate.convertAndSend("/topic/group", message);
    }
}
