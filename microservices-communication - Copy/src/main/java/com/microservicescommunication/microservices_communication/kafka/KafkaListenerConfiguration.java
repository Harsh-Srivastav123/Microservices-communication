package com.microservicescommunication.microservices_communication.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicescommunication.microservices_communication.common.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

@Configuration
@Slf4j
public class KafkaListenerConfiguration {

    @Autowired
    SimpMessageSendingOperations messagingTemplate;
    @KafkaListener(topics="kafka-topic-2",groupId = "group-2")
    public void updateChat(String value){
        log.info("message received in kafka listener microservice-B");
        ObjectMapper mapper=new ObjectMapper();
        Message message;
        try {
            log.info(value);
            message = mapper.readValue(value, Message.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        messagingTemplate.convertAndSend("/topic/group" , message);
    }
}
