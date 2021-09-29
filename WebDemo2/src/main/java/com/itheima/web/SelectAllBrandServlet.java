package com.itheima.web;
import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SelectAllBrandServlet", value = "/api/selectAll")
public class SelectAllBrandServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        BrandService brandService=new BrandService();
        Brand [] brands=brandService.selectAllBrands();
        String json= "{\"code\":0,\"msg\":\"\",\"count\":1000,\"data\":"+JSON.toJSONString(brands)+"}";
        PrintWriter printWriter= response.getWriter();
        printWriter.println(json);
        printWriter.flush();



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
