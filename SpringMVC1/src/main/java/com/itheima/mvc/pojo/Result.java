package com.itheima.mvc.pojo;

public class Result {
    private Object data;
    private Integer code;
    private String msg;
    public Result(){}

//    public Result( Integer code,String msg) {
//        this.msg=msg;
//        this.code = code;
//    }

    public Result(Integer code, String msg,Object data) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
