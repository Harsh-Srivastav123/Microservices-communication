package com.microservicescommunication.microservices_communication.redis;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class RedisMessageSubscriberInitializer {

    @Autowired
    RedisMessageListenerContainer redisContainer;

    @Autowired
    RedisMessageSubscriber messageSubscriber;

    @PostConstruct
    public void init() {
        redisContainer.addMessageListener(messageSubscriber, new ChannelTopic("redis-group-2"));
    }

}
