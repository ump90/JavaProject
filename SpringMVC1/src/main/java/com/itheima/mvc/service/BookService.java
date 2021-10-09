package com.itheima.mvc.service;
import com.itheima.mvc.pojo.Book;
import java.util.List;


public interface BookService {
    List<Book> listAllBooks();
    Book getBook(int id);
    int updateBook(Book book);
    int delBook(int id);
    int addBook(Book book);

}
