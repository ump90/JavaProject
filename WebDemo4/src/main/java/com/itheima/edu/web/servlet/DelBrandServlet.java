package com.itheima.edu.web.servlet;

import com.alibaba.fastjson.JSONObject;
import com.itheima.edu.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DelBrandServlet", value = "/api/delById")
public class DelBrandServlet extends BrandServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    JSONObject jsonObject = getJson(request);
    int id = jsonObject.getInteger("id");
    int[] ids = {id};

    BrandService brandService = new BrandService();
    brandService.delByIds(ids);
    PrintWriter printWriter = response.getWriter();
    printWriter.println(0);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.doGet(request, response);
  }
}
