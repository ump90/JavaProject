package com.itheima.config;

import com.itheima.mapper.BrandMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;


public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return  sqlSessionFactoryBean;
    }
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.itheima.mapper");
        return  mapperScannerConfigurer;
    }
    @Bean
    public MapperFactoryBean<BrandMapper> brandMapper( SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<BrandMapper> factoryBean = new MapperFactoryBean<>(BrandMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

}
