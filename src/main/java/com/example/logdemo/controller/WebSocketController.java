// src/main/java/com/example/logdemo/controller/WebSocketController.java
package com.example.logdemo.controller;

import com.example.logdemo.entity.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
@Slf4j
public class WebSocketController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        chatMessage.setTimestamp(LocalDateTime.now());
        log.info("WebSocket消息: {} - {}: {}", 
                chatMessage.getRoom(), 
                chatMessage.getUsername(), 
                chatMessage.getContent());
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getUsername());
        chatMessage.setTimestamp(LocalDateTime.now());
        chatMessage.setContent(chatMessage.getUsername() + " 加入聊天室");
        log.info("用户加入聊天室: {}", chatMessage.getUsername());
        return chatMessage;
    }
}
