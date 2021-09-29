package com.itheima.edu.service;

import com.itheima.edu.mapper.UserMapper;
import com.itheima.edu.pojo.User;
import com.itheima.edu.utils.SqlSessionFactoryUtil;
import java.io.IOException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;

public class UserService {

  public boolean loginCheck(String username, String password) throws IOException {
    SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    User user = userMapper.selectUser(username, password);
    return user != null;
  }

  public int insertUser(String username, String password) throws IOException {

    SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    if (this.loginCheck(username, password)) {
      return 1;
    } else {
      userMapper.insertUser(username, password);
      return 0;
    }
  }
  public String generateCookie(String username){
    return username+":"+DigestUtils.sha1Hex(DigestUtils.md5(username));
  }


}
