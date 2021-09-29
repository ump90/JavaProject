package com.itheima.edu.web.filter;

import com.itheima.edu.service.UserService;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import javax.servlet.http.*;

@WebFilter(urlPatterns ="/index.html",filterName = "loginFilter")
public class LoginFilter implements Filter {

  @Override
  public void init(FilterConfig config) throws ServletException {
  }

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    HttpServletRequest httpServletRequest=(HttpServletRequest) request;
    HttpServletResponse httpServletResponse=(HttpServletResponse) response;
    UserService userService=new UserService();
    Cookie[] cookies=httpServletRequest.getCookies();
    HttpSession session=(HttpSession) httpServletRequest.getSession();
    boolean isLogin=false;
    if(cookies !=null){
      for (Cookie cookie : cookies) {
        if("user".equals(cookie.getName()) ){
          if(cookie.getValue()!=null){
            String[] strings=cookie.getValue().split(":");
            String goodCookie=userService.generateCookie(strings[0]);
            if(goodCookie.equals(strings[1])){
              isLogin=true;
              session.setAttribute("user",strings[0]);


            }
          }

        }
      }
    }

    if((httpServletRequest.getSession().getAttribute("user")!=null| isLogin)){
      httpServletResponse.sendRedirect("user/user1.html");
    }else{
      chain.doFilter(request, response);
    }
  }
}
