package com.example.springboot_mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_mybatisplus.bean.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author UMP90
 * @date 2021/10/10
 */
@Mapper

public interface BookDao extends BaseMapper<Book> {

}
