package com.itheima.spring.pojo;

import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class Book {
  private String name;

  public Book() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
