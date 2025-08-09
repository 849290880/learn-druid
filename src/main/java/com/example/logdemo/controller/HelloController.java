package com.example.logdemo.controller;

import com.example.logdemo.entity.Article;
import com.example.logdemo.repository.ArticleRepository;
import com.example.logdemo.service.DatabaseService;
import com.xiaoleilu.hutool.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public static void main(String[] args) {
        String a = "/Users/wuhaichao/idea-workspace/log-demo/src/main/resources/a.txt";
        List<String> strings = FileUtil.readLines(new File(a), StandardCharsets.UTF_8);
        List<String> collect = strings.stream().map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                String[] s1 = s.split("_");
                String collect1 = Arrays.stream(s1).filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        if (s.startsWith("DI")) {
                            return false;
                        }
                        if (s.startsWith("CPU")) {
                            return false;
                        }
                        if (s.equals("远动")) {
                            return false;
                        }
                        if (s.equals("远动转接入")) {
                            return false;
                        }
                        if (s.startsWith("LD1")) {
                            return false;
                        }
                        if (s.startsWith("662U")) {
                            return false;
                        }
                        if (s.startsWith("661U")) {
                            return false;
                        }
                        return true;
                    }
                }).map(new Function<String, String>() {
                            @Override
                            public String apply(String s) {
                                String replace = s.replace("662U_", "").replace("661U_", "");
                                return replace;
                            }
                        })
                        .collect(Collectors.joining("_"));
                return collect1;
            }
        }).collect(Collectors.toList());
        FileUtil.writeLines(collect,new File("b.txt"),StandardCharsets.UTF_8);

    }


}
