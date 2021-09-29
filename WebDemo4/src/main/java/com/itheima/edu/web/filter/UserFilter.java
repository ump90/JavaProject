package com.itheima.edu.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter( urlPatterns = "/user/*",filterName = "userFilter")
public class UserFilter implements Filter {

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

    if(httpServletRequest.getSession().getAttribute("user")==null){
      httpServletResponse.sendRedirect("../index.html");
    }else{
      chain.doFilter(request, response);
    }
  }
}
