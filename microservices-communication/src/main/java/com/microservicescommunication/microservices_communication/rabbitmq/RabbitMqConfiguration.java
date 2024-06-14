package com.microservicescommunication.microservices_communication.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {


    public static final String EXCHANGE = "exchangeA";
    public static final String QUEUE = "queueA";
    public static final String ROUTING_KEY = "keyA";

    @Bean
    TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    Queue queue() {
        return new Queue(QUEUE, false);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}
