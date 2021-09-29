package com.itheima.ump90;

public class BookDaoFactory2 {
  public BookDao getBookDao() {
    System.out.println("factory 2");
    return new BookDaoImp();
  }
}
