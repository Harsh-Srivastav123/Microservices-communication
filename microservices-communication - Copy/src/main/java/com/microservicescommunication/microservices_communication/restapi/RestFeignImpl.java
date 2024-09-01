package com.microservicescommunication.microservices_communication.restapi;

import com.microservicescommunication.microservices_communication.common.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "MICROSERVICE-A")
public interface RestFeignImpl {
    @PostMapping("/rest")
    public void restCall(Message message);
}
