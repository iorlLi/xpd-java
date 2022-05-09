package com.xpd.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String name = UUID.randomUUID().toString().substring(0, 6);
        String sql = "insert into city (name, age) values ( ?, 3)";
        jdbcTemplate.update(sql, name);
    }
}
