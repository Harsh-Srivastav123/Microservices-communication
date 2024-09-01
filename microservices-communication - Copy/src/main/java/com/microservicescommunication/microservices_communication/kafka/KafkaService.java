package com.microservicescommunication.microservices_communication.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicescommunication.microservices_communication.common.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaService {


    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public void send(Message message) {
        log.info("message received in kafka service  microservice-B");
        try{

            kafkaTemplate.send("kafka-topic-1",objectMapper.writeValueAsString(message));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
