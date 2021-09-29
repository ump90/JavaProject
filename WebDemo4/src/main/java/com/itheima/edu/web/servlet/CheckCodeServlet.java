package com.itheima.edu.web.servlet;

import com.itheima.edu.utils.CheckCodeUtil;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckCodeServlet", value = "/api/checkcode")
public class CheckCodeServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ServletOutputStream outputStream=response.getOutputStream();
    HttpSession httpSession=request.getSession();
    String checkCode = CheckCodeUtil.outputVerifyImage(100, 50, outputStream, 4);
    httpSession.setAttribute("checkCode", checkCode);



  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      response.sendError(403);

  }
}
