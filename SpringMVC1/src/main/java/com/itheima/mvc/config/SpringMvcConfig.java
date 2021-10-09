package com.itheima.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc

@ComponentScan({"com.itheima.mvc.controller","com.itheima.mvc.config"})
public class SpringMvcConfig {
}
