package com.itheima.web;

import com.itheima.service.BrandService;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookiesServlet", value = "/cookie")
public class CookiesServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Cookie[] cookies=request.getCookies();
    boolean isLogin=false;
    BrandService brandService=new BrandService();
    for (Cookie cookie : cookies) {
      if ("value".equals(cookie.getName())){
        String email=cookie.getValue().split(":")[0];
        System.out.println(cookie.getValue().split(":")[1]);
        System.out.println(brandService.getCookie(email));
        if(cookie.getValue().split(":")[1].equals(brandService.getCookie(email))){
          PrintWriter printWriter=response.getWriter();
          printWriter.write("Login Success");
          printWriter.flush();
          printWriter.close();
          isLogin=true;
        }

      }
    }
    if(!isLogin){
      response.sendError(403);
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.doGet(request, response);
  }

}
