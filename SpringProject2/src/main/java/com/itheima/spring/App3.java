package com.itheima.spring;

import com.itheima.spring.config.SpringConfig;
import com.itheima.spring.pojo.User;
import com.itheima.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App3 {
  public static void main(String[] args) {
      ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
      UserService userService=applicationContext.getBean(UserService.class);
      List<User> users=userService.listAllUser();
    for (User user : users) {
      System.out.println(user);
    }
  }
}
