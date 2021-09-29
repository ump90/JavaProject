package com.itheima.edu;

import com.itheima.edu.mapper.WebMapper;
import com.itheima.edu.pojo.Manager;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/login")
public class UserLogin extends MyServlet{
    @Override
    protected void doGET(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        String user=servletRequest.getParameter("user");
        String password=servletRequest.getParameter("password");
        SqlSessionFactory sqlSessionFactory=SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession= sqlSessionFactory.openSession();
        WebMapper webMapper=sqlSession.getMapper(WebMapper.class);
        Manager manager= webMapper.queryByUserAndPass("user","password");
        PrintWriter printWriter=servletResponse.getWriter();
        if(manager!=null){
            printWriter.println("Login Success.<br>");
        }else {
            printWriter.println("User name or the pass is wrong.<br>");
        }
        printWriter.flush();
        printWriter.close();
        sqlSession.close();


    }

    @Override
    protected void doPOST(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        super.doPOST(servletRequest, servletResponse);
    }
}
