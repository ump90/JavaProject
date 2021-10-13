package com.example.mybatisdemo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author UMP90
 * @date 2021/10/13
 */
@Data
@TableName("t_employee")
public class Employee {
    @TableField(value = "ename")
    private String name;
    @TableField(value = "empno")
    private Integer empno;
    private String job;
    @TableField(value = "MGR")
    private Integer mgr;
    @TableField(value = "Hiredate")
    private LocalDate hiredate;
    private Integer sal;
    private Integer comm;
    private Integer deptno;

}
