package com.example.springboot_mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot_mybatisplus.bean.Book;
import com.example.springboot_mybatisplus.bean.User;
import com.example.springboot_mybatisplus.dao.BookDao;
import com.example.springboot_mybatisplus.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author UMP90
 * @date 2021/10/10
 */

@SpringBootTest
public class MapperTest {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserDao userDao;



    @Test
    public void pageTest(){
        IPage<User> page=new Page<>(1,3);
        userDao.selectPage(page,null);
        System.out.println("currentID: "+page.countId());
        System.out.println("current: "+page.getCurrent());
        System.out.println("pages:"+page.getPages());
        System.out.println("size:"+page.getSize());
        System.out.println("total:"+page.getTotal());
        page.getRecords().forEach(System.out::println);
    }

    @Test
    public void bookDaoTest() {
        List<Book> bookList = bookDao.selectList(null);
        bookList.forEach(System.out::println);
    }

    @Test
    public void UserDaoTest(){
        QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
        userQueryWrapper.eq("id",1);
        userDao.selectList(userQueryWrapper).forEach(System.out::println);

        QueryWrapper<User> userQueryWrapper1=new QueryWrapper<>();
        userQueryWrapper.lambda().eq(User::getId,2);
        userDao.selectList(userQueryWrapper1).forEach(System.out::println);


        LambdaQueryWrapper<User> userLambdaQueryWrapper=new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getId,3);
        userDao.selectList(userLambdaQueryWrapper).forEach(System.out::println);

        LambdaQueryWrapper<User> userLambdaQueryWrapper1=new LambdaQueryWrapper<>();
        userLambdaQueryWrapper1.lt(User::getId,2).lt(User::getId,5);
        userDao.selectList(userLambdaQueryWrapper1).forEach(System.out::println);

    }
}
