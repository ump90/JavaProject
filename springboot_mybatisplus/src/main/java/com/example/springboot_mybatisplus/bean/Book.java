package com.example.springboot_mybatisplus.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author UMP90
 * @date 2021/10/10
 */
@Data
@TableName(value = "tbl_book")
public class Book {
    @TableId(type = IdType.AUTO)
    private int id;
    private String type;
    private String name;
    private String description;

}
