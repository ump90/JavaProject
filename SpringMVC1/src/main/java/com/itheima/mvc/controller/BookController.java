package com.itheima.mvc.controller;

import com.itheima.mvc.pojo.Book;
import com.itheima.mvc.pojo.Code;
import com.itheima.mvc.pojo.Result;
import com.itheima.mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
  @Autowired private BookService bookService;

  @GetMapping
  public Result listBooks() throws Exception {
    List<Book> list=bookService.listAllBooks();

    if(list !=null){
      return new Result(Code.GET_OK,"Success",list);
    }else {
      throw new Exception();
//      return new Result(Code.GET_ERROR,"Error", null);
    }
  }

  @GetMapping("/{id}")
  public Result getById(@PathVariable int id) throws Exception {
    Book book=bookService.getBook(id);
    if(book!=null){
      return new Result(Code.GET_OK,"Success",book);
    }else {
      throw new Exception();
//      return new Result(Code.GET_ERROR,"Error",null);
    }

  }

  @PutMapping
  public Result update(@RequestBody Book book) {
    int flag=bookService.updateBook(book);
    if(flag<1){
      return new Result(Code.UPDATE_OK,"Success",null);
    }else {
      return new Result(Code.UPDATE_ERROR,"Error",null);
    }
  }

  @DeleteMapping("/{id}")
  public Result delete(@PathVariable int id) {
    int flag=bookService.delBook(id);
    if(flag<1){
      return new Result(Code.DEL_OK,"Success",null);
    }else {
      return new Result(Code.DEL_ERROR,"Error",null);
    }
  }

  @PostMapping
  public Result add(@RequestBody Book book) {
    int flag=bookService.addBook(book);
    if(flag<1){
      return new Result(Code.ADD_OK,"Success",null);
    }else {
      return new Result(Code.ADD_ERROR,"Error",null);
    }
  }
}
