package com.itheima.edu.web.servlet;
import com.itheima.edu.service.UserService;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import org.apache.commons.codec.digest.DigestUtils;

@WebServlet(name = "loginServlet",urlPatterns = "/api/login.do")
public class UserLoginServlet extends HttpServlet {
  public static String isLogin="true";
  public static String isLoginParameter="remember";
  private UserService userService=new UserService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      response.sendError(403);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    String encodePassword=DigestUtils.sha1Hex(password);

    if(userService.loginCheck(username,encodePassword)){
      if(isLogin.equals(request.getParameter(isLoginParameter))){
        UserService userService=new UserService();
        String cookieValue=userService.generateCookie(username);
        Cookie cookie= new Cookie("user",cookieValue);
        cookie.setMaxAge(24*60*60*7);
        cookie.setPath("/");
        cookie.setHttpOnly(true);

        response.addCookie(cookie);

      }
      HttpSession session=request.getSession();
      session.setAttribute("user",username);
      response.setCharacterEncoding("UTF-8");
      PrintWriter printWriter=response.getWriter();
      printWriter.println("1");
      printWriter.close();
      printWriter.flush();

    }else {
      PrintWriter printWriter=response.getWriter();
      printWriter.println("0");
      printWriter.close();
      printWriter.flush();
    };


  }
}
