package com.itheima.ump90;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {
      ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ApplicationContext.xml");
//      BookService bookService=applicationContext.getBean(BookService.class);
//      bookService.save();
      BookDao bookDao=applicationContext.getBean(BookDao.class);
      bookDao.save("book");
  }
}
