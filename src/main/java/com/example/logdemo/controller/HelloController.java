package com.example.logdemo.controller;

import com.example.logdemo.entity.Article;
import com.example.logdemo.repository.ArticleRepository;
import com.example.logdemo.service.DatabaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class HelloController {

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("hello")
    public String hello(){
//        databaseService.queryDatabase();
//        List<Article> all = articleRepository.findAll();
        Optional<Article> byId = articleRepository.findById(1);
        log.debug("hello");
        return "hello";
    }


}
