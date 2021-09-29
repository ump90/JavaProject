package com.itheima.edu.mapper;

import com.itheima.edu.pojo.Manager;
import com.itheima.edu.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface WebMapper {
  void addUser(@Param("user") String user, @Param("password") String password);
  Manager queryByUserAndPass(@Param("user") String user, @Param("password") String password);
  User[] selectAll();
  Manager queryByName(@Param("user") String user);

}
