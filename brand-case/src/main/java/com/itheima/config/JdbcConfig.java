package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class JdbcConfig {
    @Value("com.mysql.jdbc.Driver")
    private String driver;
    @Value("jdbc:mysql:///db1?useSSL=false")
    private String url;
    @Value("root")
    private String username;
    @Value("root")
    private String password;

    @Bean

    public DataSource dataSource() {
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }
}
