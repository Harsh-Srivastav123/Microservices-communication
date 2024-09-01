package com.microservicescommunication.microservices_communication.awssns;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SqsSubscriber {

//
//    @Autowired
//    SimpMessageSendingOperations messagingTemplate;
//
//    @Autowired
//    ObjectMapper mapper;
//
//    @SqsListener("ms-queue")
//    public void loadMessageFromSQS(String message)  {
//        log.info("message from SQS Queue {}",message);
//    }
}
