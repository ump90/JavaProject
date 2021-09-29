package com.itheima;

import com.itheima.dao.OrderDao;
import com.itheima.dao.UserDao;
import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***
 * 今日代码学习知识点：
 * 1.Spring版本，Spring核心概念，Bean基础配置，实例化3种方式，Bean的生命周期， 数据注入
 *
 * 今日要求，按照提示的要求，运行能正常运行此main方法
 *
 * 通过配置xml，完成以下输出：
 *
 *
 *我是BookDaoImpl的无惨构造
 书名：天龙八部
 书名：遮天
 书名：葵花宝典
 username=张三
 我是通过FactoryBean方式创建的... OrderDaoImpl
 *
 */
public class AppTest {
    public static void main(String[] args) {
        //1.加载类路径下的配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) ctx.getBean("bookService");
        OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
        bookService.printBookServiceInfo();
        orderDao.printOrder();
    }
}
