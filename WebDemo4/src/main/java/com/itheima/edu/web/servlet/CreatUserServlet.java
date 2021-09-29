package com.itheima.edu.web.servlet;

import com.itheima.edu.service.UserService;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import org.apache.commons.codec.digest.DigestUtils;

@WebServlet(name = "CreatUserServlet", value = "/api/creatuser")
public class CreatUserServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.sendError(403);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    int returnCode=0;
    PrintWriter printWriter=response.getWriter();
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    String receviedCheckCode =request.getParameter("checkCode");
    HttpSession session=request.getSession();
    String checkCode= (String) session.getAttribute("checkCode");
    if(checkCode.equals(receviedCheckCode)){
      UserService userService=new UserService();

      printWriter.println(userService.insertUser(username, DigestUtils.sha1Hex(password)));
      printWriter.flush();
    }else {
      returnCode=-1;
    }
    printWriter.println(returnCode);




  }
}
