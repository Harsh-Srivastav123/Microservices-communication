package com.microservicescommunication.microservices_communication.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicescommunication.microservices_communication.common.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@Slf4j
public class RestService {


    @Autowired
    SimpMessageSendingOperations messagingTemplate;
    
    
    public void send(Message message) {
        log.info("message received in rest service microservice-2");
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            URL weburl = new URL("http://localhost:8000/rest");
            HttpURLConnection webConnection = (HttpURLConnection) weburl.openConnection();
            webConnection.setRequestMethod("POST");
            webConnection.setRequestProperty("Accept", "application/json");
            webConnection.setRequestProperty("Content-Type", "application/json");
            webConnection.setDoOutput(true);
            String jsonPayload=objectMapper.writeValueAsString(message);
            // Send JSON payload
            try (OutputStream os = webConnection.getOutputStream()) {
                byte[] input = jsonPayload.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            log.info("Response status   "+String.valueOf(webConnection.getResponseCode()));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void receiveMessage(Message message) {
        log.info("message received in from rest controller microservice-2");
        log.info(message.toString());
        messagingTemplate.convertAndSend("/topic/group",message);
    }
}
