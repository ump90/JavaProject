package com.example.springboot_mybatisplus.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author UMP90
 * @date 2021/10/10
 */
@Data

@TableName(value = "user")
public class User {
    private String name;
    @TableId(type = IdType.AUTO)
    private int id;
    private String password;
    private int age;
    private String tel;
    @Version
    private Integer version;

}
