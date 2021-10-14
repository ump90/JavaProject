package com.itheima.mybatistest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.mybatistest.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author UMP90
 * @date 2021/10/13
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
