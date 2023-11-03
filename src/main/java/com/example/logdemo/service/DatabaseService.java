package com.example.logdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class DatabaseService {

    private final DataSource dataSource;

    @Autowired
    public DatabaseService(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void queryDatabase() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM t_grow_user_kpi");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // 处理结果集
                System.out.println();
            }
        } catch (SQLException e) {
            // 处理异常
        }
    }
}
