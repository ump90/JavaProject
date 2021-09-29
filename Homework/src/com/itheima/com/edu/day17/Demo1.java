package com.itheima.com.edu.day17;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class Demo1 {
  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    Class clazz=Class.forName("com.itheima.com.edu.day17.Person");
    Constructor constructor=clazz.getDeclaredConstructor(String.class,int.class);
    Person p1=(Person) constructor.newInstance("Tom",18);
    p1.run();
    Method method1=clazz.getMethod("show", Date.class);
    method1.invoke(p1,new Date());
    Method method2=clazz.getMethod("copy", String.class);
    method2.invoke(p1,"D:\\test.txt");

  }
}
