package com.microservicescommunication.microservices_communication.awssns;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicescommunication.microservices_communication.common.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SnsService {
//    @Autowired
//    SnsPublisher snsPublisher;

    @Autowired
    ObjectMapper mapper;
    public  void send(Message message) {
        log.info(message.toString());
//        try {
//            snsPublisher.sendMessage(mapper.writeValueAsString(message));
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
    }
}
