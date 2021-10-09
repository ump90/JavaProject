package com.itheima.mvc.dao;

import com.itheima.mvc.pojo.Book;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface BookDao {
    List<Book> selectAll();
    int add(Book book);
    int del(int id);
    int update(Book book);
    Book selectById(int id);

}
