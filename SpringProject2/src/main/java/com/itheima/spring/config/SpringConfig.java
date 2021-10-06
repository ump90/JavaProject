package com.itheima.spring.config;

import org.springframework.context.annotation.*;
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.itheima.spring")

@Import({JdbcConfig.class,MybatisConfig.class})
public class SpringConfig {

}
