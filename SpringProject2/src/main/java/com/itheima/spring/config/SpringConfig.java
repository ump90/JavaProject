package com.itheima.spring.config;

import org.springframework.context.annotation.*;
@Configuration
@ComponentScan("com.itheima.spring")
//
//@PropertySource({"classpath:jdbc.properties"})

@Import({JdbcConfig.class,MybatisConfig.class})
public class SpringConfig {

}
