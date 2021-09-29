package com.itheima.ump90;

import org.springframework.stereotype.Component;

@Component("bookDao")
public class BookDaoImp implements BookDao {
//    public BookDaoImp() {
//    System.out.println("BookDao init");
//    }

//    public static BookDaoImp getBookDao() {
//        return null;
//    }


    @Override
    public void save(String bookName) {
    System.out.println("The book "+bookName+" has been saved.");
    }
}
