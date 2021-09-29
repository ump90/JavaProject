package com.itheima.edu.web.servlet;

import com.alibaba.fastjson.JSONObject;
import com.itheima.edu.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BrandPageServlet", value = "/api/page")
public class BrandPageServlet extends BrandServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    JSONObject jsonObject = getJson(request);
    String statusString = jsonObject.getString("status");
    String companyName = jsonObject.getString("companyName");
    String brandName = jsonObject.getString("brandName");
    Integer status;
    System.out.println(statusString);
    if ("".equals(statusString)) {
      status = -1;
    } else {
      status = Integer.parseInt(statusString);
    }
    BrandService brandService = new BrandService();
    int page = brandService.getPage(status, companyName, brandName);
    PrintWriter printWriter = response.getWriter();
    printWriter.println(page);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.doGet(request, response);
  }
}
