package com.itheima.spring.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class User {
    private String id;
    private String username;
    private  String money;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + money + '\'' +
                '}';
    }
}
