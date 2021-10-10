package com.example.springboot_mybatisplus;

import com.example.springboot_mybatisplus.bean.User;
import com.example.springboot_mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author UMP90
 * @date 2021/10/10
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void searchTest() {
        User user=new User();
        user.setName("张");
        userService.searchUser(user).forEach(System.out::println);
    }
}
