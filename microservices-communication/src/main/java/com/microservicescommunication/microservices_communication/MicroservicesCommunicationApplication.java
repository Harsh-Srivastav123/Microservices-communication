package com.microservicescommunication.microservices_communication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;


@SpringBootApplication
public class MicroservicesCommunicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesCommunicationApplication.class, args);
	}

}
