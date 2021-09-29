package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

public class UserDaoImpl implements UserDao {

    private String username;

    public void printName() {

        System.out.println("username="+this.username);
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
