package com.example.springboot_mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.springboot_mybatisplus.bean.User;
import com.example.springboot_mybatisplus.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author UMP90
 * @date 2021/10/10
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public boolean addUser(User user) {
        return userDao.insert(user) > 0;
    }

    public boolean delUser(int id) {
        return userDao.deleteById(id) > 0;
    }

    public boolean updateUser(User user) {
        return userDao.updateById(user) > 0;
    }

    public User getUserById(int id) {
        return userDao.selectById(id);
    }

    public List<User> getAllUser() {
        return userDao.selectList(null);
    }

    public List<User> searchUser(User user) {
        String name = user.getName();
        String tel = user.getTel();
        int age = user.getAge();
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(name != null, User::getName, name).like(age != 0, User::getId, age).like(tel != null, User::getTel, tel);
        return userDao.selectList(lambdaQueryWrapper);
    }

}
