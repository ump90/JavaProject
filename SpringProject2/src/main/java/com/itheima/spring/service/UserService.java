package com.itheima.spring.service;

import com.itheima.spring.pojo.User;
import java.util.List;

public interface UserService {
    void addUser(User user);
    void delUser(int id);
    void updateUser(User user);
    List<User> listAllUser();
    int findUser(User user);

}
