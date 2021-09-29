package com.itheima.web;

import com.itheima.service.BrandService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DelectByIdServlet", value = "/DelectByIdServlet")
public class DelectByIdServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      String data=request.getParameter("data");
      BrandService brandService=new BrandService();
      brandService.deleteById(convertStringArray(data));


  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      this.doGet(request, response);

  }
  private int [] convertStringArray(String s){
            String [] strings=s.substring(1,s.length()-2).split(",");
            int[] nums =new int[strings.length];
    for (int i = 0; i < strings.length; i++) {
        nums[i]=Integer.parseInt(strings[i]);

    }
    return nums;
  }
}
