package com.microservicescommunication.microservices_communication.awssns;

//import com.amazonaws.services.sns.AmazonSNS;
//import com.amazonaws.services.sqs.AmazonSQS;
//import com.amazonaws.services.sqs.AmazonSQSAsync;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//
//import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
//import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
//import org.springframework.context.annotation.Bean;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Component;
//
//@Component
public class SnsPublisher {

//    @Autowired
//    AmazonSNS amazonSNS;

//    @Bean
//    public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSQS){
//        return new QueueMessagingTemplate(amazonSQS);
//    }

//    @Value("${cloud.aws.sns.topic.arn}")
//    String topicArn;
//
//    @Autowired
//    NotificationMessagingTemplate notificationMessagingTemplate;
//    public void sendMessage(String message) {
//        notificationMessagingTemplate.sendNotification(topicArn, message, "Subject");
//    }

//    @Autowired
//    QueueMessagingTemplate queueMessagingTemplate;
//
//    public void sendMessage(String message) {
//        this.queueMessagingTemplate.send("ms-queue", MessageBuilder.withPayload(message).build());
//    }
}
