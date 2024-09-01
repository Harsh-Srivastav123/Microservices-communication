package com.microservicescommunication.microservices_communication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/microservice-b")
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "index";
    }
//    @GetMapping("/test")
//    public String test(){
//        return "test";
//    }
}
