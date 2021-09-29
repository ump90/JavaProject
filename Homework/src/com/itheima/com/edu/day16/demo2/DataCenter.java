package com.itheima.com.edu.day16.demo2;

import java.util.HashMap;

public class DataCenter {
    public static HashMap<String, String> clientMap = new HashMap<>();
    public static HashMap<String,String> serverMap =new HashMap<>();
    static {
        clientMap.put("1","test.txt");
        serverMap.put("1","D:\\test.txt");
    }
}
