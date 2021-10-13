package com.example.mybatisdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisdemo.pojo.Employee;
import com.example.mybatisdemo.pojo.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author UMP90
 * @date 2021/10/13
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    @Select("SELECT AVG(sal) as averageSal FROM t_employee WHERE deptno = 10 ;")
    int averageSal();

    @Select("SELECT deptno,COUNT(*) as sum from t_employee group by deptno;")
    List<Result> selectSum();
}
