package com.example.springboot_mybatisplus.bean;

import lombok.Data;

/**
 * @author UMP90
 * @date 2021/10/10
 */
@Data
public class Message {
    private Integer code;
    private String message;
    private Object object;

    public Message(Integer code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }
}
