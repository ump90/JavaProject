package com.example.mybatisdemo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisdemo.mapper.EmployeeMapper;
import com.example.mybatisdemo.pojo.Employee;
import com.example.mybatisdemo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisDemoApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeService employeeService;

    @Test
    void contextLoads() {
    }

    @Test
    public void selectAllField() {
        employeeMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void selectAllNameAndJob() {
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(Employee::getName, Employee::getJob);
        employeeMapper.selectList(lambdaQueryWrapper).forEach(System.out::println);
    }

    @Test
    public void selectByID() {
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Employee::getDeptno, 20);
        employeeMapper.selectList(lambdaQueryWrapper).forEach(System.out::println);
    }

    @Test
    public void selectByMoneyAndJob() {
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Employee::getJob, "clear").lt(Employee::getSal, 1000);
        employeeMapper.selectList(lambdaQueryWrapper).forEach(System.out::println);
    }

    @Test
    public void selectBt() {
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.between(Employee::getSal, 2000, 3000);
        employeeMapper.selectList(lambdaQueryWrapper).forEach(System.out::println);
    }

    @Test
    public void selectNullSal() {
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.isNull(Employee::getComm);
        employeeMapper.selectList(lambdaQueryWrapper).forEach(System.out::println);
    }

    @Test
    public void selectBetParts() {
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.between(Employee::getDeptno, 10, 20);
        employeeMapper.selectList(lambdaQueryWrapper).forEach(System.out::println);
    }

    @Test
    public void selectByM() {
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Employee::getName, "M");
        employeeMapper.selectList(lambdaQueryWrapper).forEach(System.out::println);
    }

    @Test
    public void order() {
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByAsc(Employee::getSal);
        employeeMapper.selectList(lambdaQueryWrapper).forEach(System.out::println);
    }

    @Test
    public void totalNumber() {
        System.out.println(employeeMapper.selectCount(null));
    }

    @Test
    public void getid10() {
        System.out.println(employeeMapper.averageSal());


    }

    @Test
    public void sumGroup() {
        System.out.println(employeeMapper.selectSum());
    }

}
