package com.itheima.edu.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "BrandServlet")
public class BrandServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}

  public void returnJson(HttpServletResponse response, String returnData) throws IOException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("multipart/form-data; application/json");
    PrintWriter printWriter = response.getWriter();
    printWriter.println(returnData);
  }

  public JSONObject getJson(HttpServletRequest request) throws IOException {
    request.setCharacterEncoding("UTF-8");
    BufferedReader br =
        new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
    String line = null;
    StringBuilder sb = new StringBuilder();
    while ((line = br.readLine()) != null) {
      sb.append(line);
    }
    return JSON.parseObject(sb.toString());
  }
}
