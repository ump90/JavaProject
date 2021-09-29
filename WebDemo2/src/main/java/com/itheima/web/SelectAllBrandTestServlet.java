package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "SelectAllBrandTestServlet", value = "/api/selectAllTest")
public class SelectAllBrandTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession= sqlSessionFactory.openSession();
        BrandMapper brandMapper=sqlSession.getMapper(BrandMapper.class);
        Brand [] brands= brandMapper.selectAll();
        String json= JSON.toJSONString(brands);
        OutputStream outputStream= response.getOutputStream();
        outputStream.write(json.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
