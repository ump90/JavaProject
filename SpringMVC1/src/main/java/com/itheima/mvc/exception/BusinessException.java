package com.itheima.mvc.exception;

/**
 * @author UMP90
 * @date 2021/10/9
 */

public class BusinessException extends RuntimeException{
    private Integer code;
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }
    public BusinessException(Integer code,String message,Throwable cause) {
        super(message, cause);
        this.code = code;
    }


}
