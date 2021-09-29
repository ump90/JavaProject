package com.itheima.edu.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itheima.edu.mapper.BrandMapper;
import com.itheima.edu.pojo.Brand;
import com.itheima.edu.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "DelBrandsServlet", value = "/api/delByIds")
public class DelBrandsServlet extends BrandServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    JSONObject jsonObject = getJson(request);
    List<Brand> list =
        JSONArray.parseArray(jsonObject.get("multipleSelection").toString(), Brand.class);
    BrandService brandService = new BrandService();
    brandService.delByIds(list);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.doGet(request, response);
  }
}
