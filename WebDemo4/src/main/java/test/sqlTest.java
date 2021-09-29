package test;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itheima.edu.mapper.BrandMapper;
import com.itheima.edu.pojo.Brand;
import com.itheima.edu.service.BrandService;
import com.itheima.edu.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class sqlTest {

  public static void main(String[] args) throws IOException {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
    SqlSession sqlSession = sqlSessionFactory.openSession();
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
    String s =
        "{\"multipleSelection\":[{\"brandName\":\"test\",\"companyName\":\"test\",\"description\":\"test\",\"id\":50,\"ordered\":10087,\"status\":1,\"statusStr\":\"启用\"}]}";
    JSONObject jsonObject = JSON.parseObject(s);

    List<Brand> multipleSelection =
        JSONArray.parseArray(jsonObject.get("multipleSelection").toString(), Brand.class);

    int[] idLIst = new int[multipleSelection.size()];
    for (int i = 0; i < multipleSelection.size(); i++) {
      idLIst[i] = multipleSelection.get(i).getId();
    }
    brandMapper.delByIds(idLIst);
  }
}
