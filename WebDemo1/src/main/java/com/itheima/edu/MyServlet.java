package com.itheima.edu;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        String httpMethod =httpServletRequest.getMethod();
        servletResponse.setContentType("text/html;charset=utf-8");
        servletResponse.setCharacterEncoding("UTF-8");
        servletRequest.setCharacterEncoding("UTF-8");
        if("POST".equals(httpMethod)){
            doPOST(servletRequest,servletResponse);
        }else if("GET".equals(httpMethod)){
            doGET(servletRequest,servletResponse);
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
    protected void doGET(ServletRequest servletRequest,ServletResponse servletResponse) throws IOException {

    }
    protected void doPOST(ServletRequest servletRequest,ServletResponse servletResponse) throws IOException {

    }
}
