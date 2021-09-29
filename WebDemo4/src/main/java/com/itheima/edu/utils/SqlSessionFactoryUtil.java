package com.itheima.edu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public SqlSessionFactoryUtil() {
    }


    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        return sqlSessionFactory;

    }
    public static SqlSession getSqlSession() throws IOException{
        return sqlSessionFactory.openSession();
    }
}
