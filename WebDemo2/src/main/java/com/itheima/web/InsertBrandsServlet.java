package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "InsertBrandsServlet", value = "/InsertBrandsServlet")
public class InsertBrandsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String jsonData=request.getParameter("data");
        JSONArray jsonArray= JSON.parseArray(jsonData);
        ArrayList<Brand> brandArrayList=new ArrayList<>();
        for (Object o : jsonArray) {
            Brand brand= JSONObject.parseObject(o.toString(),Brand.class);
            brandArrayList.add(brand);
        }
        BrandService brandService=new BrandService();
        brandService.insert(brandArrayList);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
