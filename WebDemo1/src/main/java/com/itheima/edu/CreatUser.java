package com.itheima.edu;

import com.itheima.edu.mapper.WebMapper;
import com.itheima.edu.pojo.Manager;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addUser")
public class CreatUser extends MyServlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
    }

    @Override
    protected void doGET(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        SqlSessionFactory sqlSessionFactory=SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        WebMapper webMapper=sqlSession.getMapper(WebMapper.class);

        String user=servletRequest.getParameter("user");
        String password=servletRequest.getParameter("password");

        Manager manager=webMapper.queryByName(user);
        if(manager==null){
            webMapper.addUser(user,password);
            PrintWriter printWriter=servletResponse.getWriter();
            printWriter.write("Register successfully");
        }else {
            PrintWriter printWriter=servletResponse.getWriter();
            printWriter.write("The user name has been registered.");

        }
        sqlSession.close();



    }

    @Override
    protected void doPOST(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        super.doPOST(servletRequest, servletResponse);
    }
}
