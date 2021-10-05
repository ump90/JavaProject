package com.itheima.service.impl;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("brandService")
public class BrandServiceImpl implements BrandService {
    @Autowired
//    private SqlSessionFactory sqlSessionFactory;
    private BrandMapper brandMapper;
    //1. 创建SqlSessionFactory 工厂对象
//    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public List<Brand> selectAll() {
        //2. 获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //3. 获取BrandMapper
//        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法

        //5. 释放资源

        return brandMapper.selectAll();
    }

    @Override
    public void add(Brand brand) {
//        //2. 获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //3. 获取BrandMapper
//        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        brandMapper.add(brand);

    }

    @Override
    public void deleteByIds(int[] ids) {
        //2. 获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //3. 获取BrandMapper
//        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        brandMapper.deleteByIds(ids);

//        sqlSession.commit();//提交事务
//
//        //5. 释放资源
//        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        //2. 获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //3. 获取BrandMapper
//        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4. 计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        //5. 查询当前页数据
        List<Brand> rows = brandMapper.selectByPage(begin, pageSize);
        //6. 查询总记录数
        int totalCount = brandMapper.selectTotalCount();
        //7. 封装PageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
//        //8. 释放资源
//        sqlSession.close();
        return pageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        //2. 获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //3. 获取BrandMapper
//        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);


        //4. 计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数

        // 处理brand条件，模糊表达式
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }

        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            brand.setCompanyName("%" + companyName + "%");
        }


        //5. 查询当前页数据
        List<Brand> rows = brandMapper.selectByPageAndCondition(begin, pageSize, brand);

        //6. 查询总记录数
        int totalCount = brandMapper.selectTotalCountByCondition(brand);

        //7. 封装PageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

//
//        //8. 释放资源
//        sqlSession.close();

        return pageBean;
    }


}
