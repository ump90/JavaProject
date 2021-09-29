package com.itheima.edu.web.servlet;

import com.alibaba.fastjson.JSONObject;
import com.itheima.edu.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BrandSearchServlet", value = "/api/search")
public class BrandSearchServlet extends BrandServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JSONObject jsonObject = getJson(request);
    String statusString = jsonObject.getString("status");
    String companyName = jsonObject.getString("companyName");
    String brandName = jsonObject.getString("brandName");
    int page = jsonObject.getInteger("page");
    int size = jsonObject.getInteger("size");
    BrandService brandService = new BrandService();
    Integer status;
    System.out.println(statusString);
    if ("".equals(statusString)) {
      status = -1;
    } else {
      status = Integer.parseInt(statusString);
    }

    String returnData = brandService.searchBrands(page, size, brandName, companyName, status);
    returnJson(response, returnData);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.doGet(request, response);
  }
}
