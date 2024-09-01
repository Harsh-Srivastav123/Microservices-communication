package com.microservicescommunication.microservices_communication.controller;

import com.microservicescommunication.microservices_communication.awssns.SnsService;
import com.microservicescommunication.microservices_communication.awssqs.SqsService;
import com.microservicescommunication.microservices_communication.common.Message;
import com.microservicescommunication.microservices_communication.common.Utils;
import com.microservicescommunication.microservices_communication.grpc.GrpcService;
import com.microservicescommunication.microservices_communication.kafka.KafkaService;
import com.microservicescommunication.microservices_communication.rabbitmq.RabbitMqService;
import com.microservicescommunication.microservices_communication.redis.RedisService;
import com.microservicescommunication.microservices_communication.restapi.RestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
//@RequestMapping("test/a")
public class MainController {

    //subscribe to general

    @Autowired
    SimpMessageSendingOperations messagingTemplate;

    @Autowired
    RedisService redisService;
    @Autowired
    GrpcService grpcService;
    @Autowired
    SnsService snsService;
    @Autowired
    RabbitMqService rabbitMqService;
    @Autowired
    KafkaService kafkaService;
    @Autowired
    RestService restService;

    @Autowired
    SqsService sqsService;

    @MessageMapping("/message")
    public void message(@Payload Message message){
        if(!Utils.methodList.contains(message.getMethod())){
            log.info("method is not specified properly !!!");
            messagingTemplate.convertAndSend("/group","Check the method properly");
        }
        log.info(message.toString());
        switch (message.getMethod()) {
            case "redis":
                redisService.send(message);
                break;
            case "grpc":
                grpcService.send(message);
                break;
            case "aws-sns":
                snsService.send(message);
                break;
            case "aws-sqs":
                sqsService.send(message);
                break;
            case "kafka":
                kafkaService.send(message);
                break;
            case "rabbitmq":
                rabbitMqService.send(message);
                break;
            case "rest":
                restService.send(message);
                break;
            default:
                throw new IllegalArgumentException("Unknown method: " + message.getMethod());
        }

    }

    @PostMapping("/rest")
    public void restMessage(@RequestBody Message message){
        restService.receiveMessage(message);
    }

//    @GetMapping("/")
//    public Object test(){
//        return "test microservice -a";
//    }
@GetMapping("/microservice-b/test")
public Object test(){
    return "testing server - b";
}

}
