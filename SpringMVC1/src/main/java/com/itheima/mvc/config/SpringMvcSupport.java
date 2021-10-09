package com.itheima.mvc.config;

import com.itheima.mvc.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author UMP90
 * @date 2021/10/9
 */
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
  @Autowired
  private ProjectInterceptor projectInterceptor;
  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    registry.addResourceHandler("/index.jsp").addResourceLocations("/index.jsp");
  }

  @Override
  protected void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(projectInterceptor).addPathPatterns("/api/book","/api/book/*");
  }
}
