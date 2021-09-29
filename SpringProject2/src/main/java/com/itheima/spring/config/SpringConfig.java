package com.itheima.spring.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.itheima.spring")
//
//@PropertySource({"classpath:jdbc.properties"})
@Import({JdbcConfig.class})
public class SpringConfig {

}
