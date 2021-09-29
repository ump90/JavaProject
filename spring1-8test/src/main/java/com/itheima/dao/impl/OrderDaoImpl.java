package com.itheima.dao.impl;

import com.itheima.dao.OrderDao;

public class OrderDaoImpl implements OrderDao {

    public void printOrder() {
        System.out.println("我是通过FactoryBean方式创建的... OrderDaoImpl");
    }
}
