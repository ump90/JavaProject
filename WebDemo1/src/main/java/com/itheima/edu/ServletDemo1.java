package com.itheima.edu;

import com.itheima.edu.mapper.WebMapper;
import com.itheima.edu.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/demo2")
public class ServletDemo1 extends MyServlet {
  @Override
  protected void doGET(ServletRequest servletRequest, ServletResponse servletResponse)
      throws IOException {
    SqlSessionFactory sqlSessionFactory=SqlSessionFactoryUtil.getSqlSessionFactory();
    SqlSession sqlSession=sqlSessionFactory.openSession();
    WebMapper webMapper=sqlSession.getMapper(WebMapper.class);
    User[] users=webMapper.selectAll();

    PrintWriter printWriter=servletResponse.getWriter();
    for (User user : users) {
      printWriter.write(user.toString());
      printWriter.write("<br>");
    }
    printWriter.flush();
    printWriter.close();
    sqlSession.close();


  }

  @Override
  protected void doPOST(ServletRequest servletRequest, ServletResponse servletResponse)
      throws IOException {
    this.doGET(servletRequest, servletResponse);
  }
}
