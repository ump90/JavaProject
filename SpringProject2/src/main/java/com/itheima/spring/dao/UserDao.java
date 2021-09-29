package com.itheima.spring.dao;

import com.itheima.spring.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("userDao")
public interface UserDao {
    @Insert("Insert into spring_db")
    void addUser(User user);
    void delUser(int id);
    void updateUser(User user);
    int findUser(User user);
    List<User> listUser();
}
