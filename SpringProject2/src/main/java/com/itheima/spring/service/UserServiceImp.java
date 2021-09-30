package com.itheima.spring.service;

import com.itheima.spring.dao.UserDao;
import com.itheima.spring.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
  @Autowired
  private UserDao userDao;

  @Override
  public void addUser(User user) {
    userDao.addUser(user);
  }

  @Override
  public void delUser(int id) {
    userDao.delUser(id);
  }

  @Override
  public void updateUser(User user) {
      userDao.updateUser(user);
  }

  @Override
  public List<User> listAllUser() {
    return userDao.listUser();
  }

  @Override
  public int findUser(User user) {
    return userDao.findUser(user);
  }
}
