package com.example.logdemo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "t_comment")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "content")
    private String content;
    @Column(name = "author")
    private String author;
    @Column(name = "a_id")
    private Integer aId;

}
