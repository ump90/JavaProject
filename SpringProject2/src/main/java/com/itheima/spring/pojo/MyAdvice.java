package com.itheima.spring.pojo;

import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
  public void method() {
    System.out.println(System.currentTimeMillis());
  }
}
