package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.itheima")
//
//@PropertySource({"classpath:jdbc.properties"})

@Import({JdbcConfig.class,MybatisConfig.class})
public class SpringConfig {


}
