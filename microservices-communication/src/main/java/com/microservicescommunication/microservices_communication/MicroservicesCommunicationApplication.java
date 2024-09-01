package com.microservicescommunication.microservices_communication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class MicroservicesCommunicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesCommunicationApplication.class, args);
	}

}
