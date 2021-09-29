package com.itheima.ump90;

public class BookDaoFactory {
    public static BookDao getBookDao(){
    System.out.println("factory method");
        return  new BookDaoImp();
    }
}
