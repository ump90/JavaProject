package com.itheima.edu.mapper;

import com.itheima.edu.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface BrandMapper {
  Brand[] listAllById(@Param("startPage") int startPage, @Param("pageSize") int pageSize);

  Brand selectByIdBrand(@Param("id") int id);

  void insertAll(
      @Param("brandName") String brandName,
      @Param("companyName") String companyName,
      @Param("ordered") Integer ordered,
      @Param("description") String description,
      @Param("status") Integer status);

  void delByIds(int[] id);

  int getPage(
      @Param("brandName") String brandName,
      @Param("companyName") String companyName,
      @Param("status") int status);

  void updateById(
      @Param("id") int id,
      @Param("brandName") String brandName,
      @Param("companyName") String companyName,
      @Param("ordered") Integer ordered,
      @Param("description") String description,
      @Param("status") Integer status);

  Brand[] searchAll(
      @Param("status") int status,
      @Param("brandName") String brandName,
      @Param("companyName") String companyName,
      @Param("startPage") int startPage,
      @Param("pageSize") int pageSize);
}
