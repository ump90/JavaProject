package com.itheima.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class JdbcConfig {
  @Value("driver")
  private String driver;
  @Value("jdbc:mysql://127.0.0.1:3306/spring_db")
  private String url;
  @Value("root")
  private String username;
  @Value("asswecan")
  private  String password;
  @Bean
  public DataSource dataSource() {
    DruidDataSource druidDataSource = new DruidDataSource();
    druidDataSource.setDriverClassName(driver);
    druidDataSource.setUrl(url);
    druidDataSource.setUsername(username);
    druidDataSource.setPassword(password);
    return druidDataSource;
  }
}
