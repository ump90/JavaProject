package com.itheima.service;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.util.SqlSessionFactoryUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.io.IOException;
import java.util.List;

/**
 * @author Administrator
 */
public class BrandService {
    private final SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtil.getSqlSessionFactory();
    public BrandService() throws IOException {
    }
    public  Brand[] selectAllBrands(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BrandMapper brandMapper=sqlSession.getMapper(BrandMapper.class);
        return brandMapper.selectAll();
    }
    public void insert(List<Brand> brandList){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BrandMapper brandMapper=sqlSession.getMapper(BrandMapper.class);
        try{
            brandMapper.insert(brandList);
        }catch (Exception e){
            e.printStackTrace();
            return;
        }
        sqlSession.close();
    }
    public void deleteById(int [] list){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BrandMapper brandMapper=sqlSession.getMapper(BrandMapper.class);
        brandMapper.delById(list);

    }
    public void updateBrand(Brand brand){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BrandMapper brandMapper=sqlSession.getMapper(BrandMapper.class);

        brandMapper.updateBrand(brand);
    }
    public  int login(String email, String password){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BrandMapper brandMapper=sqlSession.getMapper(BrandMapper.class);
        return  brandMapper.login(email,password);
    }
    public String getCookie(String email){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BrandMapper brandMapper=sqlSession.getMapper(BrandMapper.class);
        return DigestUtils.sha256Hex(brandMapper.getUserpassword(email));
    }



}
