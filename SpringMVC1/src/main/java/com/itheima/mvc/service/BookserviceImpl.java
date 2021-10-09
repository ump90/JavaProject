package com.itheima.mvc.service;

import com.itheima.mvc.dao.BookDao;
import com.itheima.mvc.exception.BusinessException;
import com.itheima.mvc.pojo.Book;
import com.itheima.mvc.pojo.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookserviceImpl implements BookService {
  @Autowired private BookDao bookDao;

  @Override
  public List<Book> listAllBooks() {
    return bookDao.selectAll();
  }

  @Override
  public int addBook(Book book) {
    return bookDao.add(book);
  }

  @Override
  public int delBook(int id) {
    return bookDao.del(id);
  }

  @Override
  public int updateBook(Book book) {
    return bookDao.update(book);
  }

  @Override
  public Book getBook(int id) {
    if (id<0){
      throw new BusinessException(Code.ADD_ERROR,"test exception");
    }

    return bookDao.selectById(id);
  }
}
