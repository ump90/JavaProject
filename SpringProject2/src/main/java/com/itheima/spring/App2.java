package com.itheima.spring;

import com.itheima.spring.config.SpringConfig;
import com.itheima.spring.pojo.Book;
import com.itheima.spring.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {
  public static void main(String[] args) {
      ApplicationContext context= new AnnotationConfigApplicationContext(SpringConfig.class);

      Book book= (Book) context.getBean("bookDao",Book.class);
      book.setName("Book1");
      BookService bookService=context.getBean("bookService",BookService.class);
      bookService.saveBook();
  }
}
