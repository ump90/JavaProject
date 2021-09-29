package com.itheima.spring;

import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.spring.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
  public static void main(String[] args) throws SQLException {
    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(SpringConfig.class);
    DataSource dataSource = applicationContext.getBean(DruidDataSource.class);
    Connection connection = dataSource.getConnection();
    PreparedStatement preparedStatement =
        connection.prepareStatement("SELECT VERSION() AS version;");
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      System.out.println(resultSet.getString("version"));
    }
  }
}
