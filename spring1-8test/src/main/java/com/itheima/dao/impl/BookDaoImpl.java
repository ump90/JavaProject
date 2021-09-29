package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

import java.util.List;


public class BookDaoImpl implements BookDao {

    private List<String> booklist;

    public void setBooklist(List<String> booklist) {
        this.booklist = booklist;
    }

    public BookDaoImpl() {

        System.out.println("我是BookDaoImpl的无惨构造");
    }

    public void printBookList() {

        for (String s : booklist) {
            System.out.println("书名："+s);
        }

    }
}
