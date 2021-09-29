package com.itheima.spring.service;

import com.itheima.spring.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImplement implements BookService{
    @Autowired
    @Qualifier("bookDao")
    private Book bookDao;

    @Override
    public void saveBook() {
    System.out.println(bookDao.getName()+" has been saved");
    }

}
