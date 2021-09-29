package com.itheima.com.edu.day18;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Test {
  public static void main(String[] args) throws ClassNotFoundException, IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    FileInputStream fileInputStream=new FileInputStream("addClass.properties");
    Properties properties=new Properties();
    properties.load(fileInputStream);
    Class clazz=Class.forName(properties.getProperty("className"));
    Constructor constructor=clazz.getDeclaredConstructor();
    Object object =constructor.newInstance();
    Method[] methods=clazz.getMethods();
    BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("testResult.txt"));
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    for (Method method : methods) {
      method.setAccessible(true);
      if (method.isAnnotationPresent(AnnocationTest.class)){

        try {
          method.invoke(object);
        } catch (Exception e) {
          Date date=new Date();
          bufferedWriter.write(simpleDateFormat.format(date)+"->"+e.getCause().getClass().getSimpleName() +"->"+e.getCause().getMessage());

        }
      }

    }
    bufferedWriter.close();
  }
}
