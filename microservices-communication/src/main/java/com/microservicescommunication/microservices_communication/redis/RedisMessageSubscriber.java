package com.microservicescommunication.microservices_communication.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RedisMessageSubscriber implements MessageListener {

    @Autowired
    SimpMessageSendingOperations messagingTemplate;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("message received in redis subscriber microservice-1");
        String channel = new String(message.getChannel());
        String body = new String(message.getBody());
        log.info("channel : "+channel+"  body : "+body );
        try {
            messagingTemplate.convertAndSend("/topic/group" , objectMapper.readValue(body, com.microservicescommunication.microservices_communication.common.Message.class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
