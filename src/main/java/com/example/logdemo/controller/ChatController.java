// src/main/java/com/example/logdemo/controller/ChatController.java
package com.example.logdemo.controller;

import com.example.logdemo.entity.ChatMessage;
import com.example.logdemo.repository.ChatMessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
public class ChatController {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    /**
     * 发送消息
     */
    @PostMapping("/chat/send")
    public ChatMessage sendMessage(@RequestParam String username, 
                                   @RequestParam String content,
                                   @RequestParam(defaultValue = "default") String room) {
        ChatMessage message = new ChatMessage();
        message.setUsername(username);
        message.setContent(content);
        message.setRoom(room);
        message.setTimestamp(LocalDateTime.now());
        
        log.info("用户 {} 在房间 {} 发送消息: {}", username, room, content);
        return chatMessageRepository.save(message);
    }

    /**
     * 获取聊天记录
     */
    @GetMapping("/chat/messages")
    public List<ChatMessage> getMessages(@RequestParam(defaultValue = "default") String room) {
        return chatMessageRepository.findByRoomOrderByTimestampAsc(room);
    }
}