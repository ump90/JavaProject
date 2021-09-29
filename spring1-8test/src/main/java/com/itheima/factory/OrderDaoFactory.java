package com.itheima.factory;

import com.itheima.dao.OrderDao;
import com.itheima.dao.UserDao;
import com.itheima.dao.impl.OrderDaoImpl;
import com.itheima.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;

//静态工厂创建对象
public class OrderDaoFactory implements FactoryBean<OrderDao> {
    //代替原始实例工厂中创建对象的方法
    public OrderDao getObject() throws Exception {
//        初始化的配置
        return new OrderDaoImpl();
    }

    public Class<?> getObjectType() {
        return UserDao.class;
    }


}