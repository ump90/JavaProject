package com.itheima.mapper;

import com.itheima.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    Brand[] selectAll();
    int insert(List <Brand> brands);
    void delById(int[] ids);
    void updateBrand(Brand brand);
    int login(String email, String password);
    String getUserpassword(String userName);

}
