package com.example.logdemo.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "t_chat_message")
@Data
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "content", length = 1000)
    private String content;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "room")
    private String room;
}
