package com.itheima.edu.mapper;

import com.itheima.edu.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
  User selectUser( @Param("username") String username, @Param("password") String password);
  void insertUser(@Param("username") String username, @Param("password") String password);


}
