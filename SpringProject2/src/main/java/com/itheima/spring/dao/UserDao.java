package com.itheima.spring.dao;

import com.itheima.spring.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userDao")
public interface UserDao {
  @Insert("Insert into tbl_account (name,money) values (#{name}, #{money});")
  void addUser(User user);

  @Delete("DELETE FROM tbl_account where id=#{id}")
  void delUser(int id);

  @Update("update tbl_account set name =#{name} money=#{money} where id=#{id}")
  void updateUser(User user);

  @Select("select * from tbl_account where id=#{id}")
  int findUser(User user);

  @Select("select * from tbl_account;")
  List<User> listUser();
}
