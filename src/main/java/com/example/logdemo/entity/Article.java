package com.example.logdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity(name = "t_article")
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    // 查询时将子表一并查询出来
//    @OneToMany(fetch = FetchType.EAGER) // FetchType.LAZY 懒加载
//    @JoinTable(name = "t_comment", joinColumns = {@JoinColumn(name = "a_id")},
//            inverseJoinColumns = {@JoinColumn(name = "id")})
//    private List<Comment> commentList;

}
