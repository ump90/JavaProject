package com.itheima.web;

import com.itheima.service.BrandService;
import com.sun.org.apache.xml.internal.security.algorithms.implementations.SignatureDSA.SHA256;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import org.apache.commons.codec.digest.DigestUtils;

@WebServlet(name = "LoginServlet", value = "/api/login")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String email=request.getParameter("email");
    String password=request.getParameter("password");
    String Ciphertext= DigestUtils.sha256Hex(password);
    BrandService brandService=new BrandService();

    if (brandService.login(email,Ciphertext)>0) {
      Cookie cookie=new Cookie("value",email+":"+brandService.getCookie(email));
      cookie.setDomain("matrix");
      cookie.setPath("/");
      cookie.setMaxAge(60*60*24*7);
      response.addCookie(cookie);
      response.sendRedirect("../cookie");


    }else {
      PrintWriter printWriter=response.getWriter();
      printWriter.println("Password Error");
      printWriter.flush();
      printWriter.close();
    }


  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.doGet(request, response);

  }
}
