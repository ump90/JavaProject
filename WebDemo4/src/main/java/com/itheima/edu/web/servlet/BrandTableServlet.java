package com.itheima.edu.web.servlet;

import com.alibaba.fastjson.JSONObject;
import com.itheima.edu.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BrandTableServlet", value = "/api/table")
public class BrandTableServlet extends BrandServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    BrandService brandService = new BrandService();
    JSONObject jsonObject= getJson(request);
    int page=jsonObject.getInteger("page");
    int size=jsonObject.getInteger("size");
    String returnData =brandService.getAllBrands(page,size);
    returnJson(response, returnData);

  }



  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.doGet(request, response);
  }
}
