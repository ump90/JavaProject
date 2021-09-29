package com.itheima.spring.service;

import com.itheima.spring.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void addUser(User user);
    void delUser(int id);
    void updateUser(User user);
    List<User> listAllUser();
    int findUser(User user);

}
