package com.itheima.com.edu.day17;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo2 {
  public static void main(String[] args)
      throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
          IllegalAccessException, InstantiationException, NoSuchFieldException {
    Class<Demo2> demo2Class = Demo2.class;
    ClassLoader classLoader = demo2Class.getClassLoader();
    Properties properties = new Properties();
    InputStream inputStream = classLoader.getResourceAsStream("prop.properties");
    properties.load(inputStream);
    Class clazz = Class.forName(properties.getProperty("classname"));

    Constructor constructor = clazz.getConstructor();
    DemoClass demoClass = (DemoClass) constructor.newInstance();
    Field field = clazz.getDeclaredField("name");
    field.setAccessible(true);
    field.set(demoClass, "Tom");

    Method method = clazz.getDeclaredMethod(properties.getProperty("method"), String.class);
    method.setAccessible(true);
    method.invoke(demoClass, "Tom");
  }
}
