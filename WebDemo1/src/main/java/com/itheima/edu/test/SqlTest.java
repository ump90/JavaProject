package com.itheima.edu.test;

import com.itheima.edu.mapper.WebMapper;
import com.itheima.edu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlTest {
  public static void main(String[] args) throws IOException {
      String resource="mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
      SqlSession sqlSession=sqlSessionFactory.openSession();
      WebMapper webMapper=sqlSession.getMapper(WebMapper.class);
      String user="Tom";
      String password="Password";
      webMapper.addUser(user,password);
      sqlSession.close();



  }
}
