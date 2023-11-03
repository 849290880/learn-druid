package com.example.logdemo;

import com.example.logdemo.service.DatabaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogDemoApplicationTests {

    @Autowired
    private DatabaseService databaseService;

    @Test
    void contextLoads() {
        databaseService.queryDatabase();
    }

}
