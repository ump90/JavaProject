package com.itheima.edu.web.servlet;

import com.alibaba.fastjson.JSONObject;
import com.itheima.edu.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updateBrandServlet", value = "/api/updateBrand")
public class updateBrandServlet extends BrandServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    JSONObject jsonObject = getJson(request);
    BrandService brandService = new BrandService();
    String brandName = jsonObject.getString("brandName");
    String companyName = jsonObject.getString("companyName");
    String description = jsonObject.getString("description");
    int status = jsonObject.getInteger("status");
    int ordered = jsonObject.getInteger("ordered");
    int id = jsonObject.getInteger("id");
    brandService.updateBrand(id, brandName, companyName, status, description, ordered);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.doGet(request, response);
  }
}
