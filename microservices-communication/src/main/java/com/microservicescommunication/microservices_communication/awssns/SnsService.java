package com.microservicescommunication.microservices_communication.awssns;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicescommunication.microservices_communication.common.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnsService {
    @Autowired
    SnsPublisher snsPublisher;

    @Autowired
    ObjectMapper mapper;
    public  void send(Message message) {
        try {
            snsPublisher.sendMessage(mapper.writeValueAsString(message));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
