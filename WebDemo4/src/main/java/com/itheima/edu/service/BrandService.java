package com.itheima.edu.service;

import com.alibaba.fastjson.JSON;
import com.itheima.edu.mapper.BrandMapper;
import com.itheima.edu.pojo.Brand;
import com.itheima.edu.utils.SqlSessionFactoryUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BrandService {
  public String getAllBrands(int startPage, int pageSize) throws IOException {
    BrandMapper brandMapper = initialMapper();
    Brand[] brands = brandMapper.listAllById((startPage - 1) * pageSize, pageSize);
    return JSON.toJSONString(brands);
  }

  public String searchBrands(
      int startPage, int pageSize, String brandName, String companyName, int status)
      throws IOException {
    BrandMapper brandMapper = initialMapper();
    Brand[] brands =
        brandMapper.searchAll(status, brandName, companyName, (startPage - 1) * pageSize, pageSize);
    return JSON.toJSONString(brands);
  }

  public void addBrand(
      String brandName, String companyName, int status, String description, int ordered)
      throws IOException {
    BrandMapper brandMapper = initialMapper();
    brandMapper.insertAll(brandName, companyName, ordered, description, status);
  }

  public void updateBrand(
      int id, String brandName, String companyName, int status, String description, int ordered)
      throws IOException {
    BrandMapper brandMapper = initialMapper();
    brandMapper.updateById(id, brandName, companyName, ordered, description, status);
  }

  public void delByIds(List<Brand> multipleSelection) throws IOException {
    BrandMapper brandMapper = initialMapper();
    int[] idLIst = new int[multipleSelection.size()];
    for (int i = 0; i < multipleSelection.size(); i++) {
      idLIst[i] = multipleSelection.get(i).getId();
    }
    brandMapper.delByIds(idLIst);
  }

  public void delByIds(int[] ids) throws IOException {
    BrandMapper brandMapper = initialMapper();
    brandMapper.delByIds(ids);
  }

  public int getPage(int status, String companyName, String brandName) throws IOException {
    BrandMapper brandMapper = initialMapper();
    return brandMapper.getPage(brandName, companyName, status);
  }

  public BrandMapper initialMapper() throws IOException {
    SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
    return sqlSession.getMapper(BrandMapper.class);
  }
}
