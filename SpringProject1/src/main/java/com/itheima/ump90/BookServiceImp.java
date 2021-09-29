package com.itheima.ump90;

import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class BookServiceImp implements BookService {
  private BookDao bookDao;



  public BookServiceImp() {
    System.out.println("BookService init");
  }

  @Override
  public void save() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please input the name of book");
    String bookName=scanner.nextLine();
    bookDao.save(bookName);

  }
  public void setBookDao(BookDao bookDao){
    this.bookDao=bookDao;
  }
}
