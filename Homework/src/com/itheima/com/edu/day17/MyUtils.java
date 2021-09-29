package com.itheima.com.edu.day17;

import java.lang.reflect.Field;

public class MyUtils{
    private MyUtils() {
    }
    /*
        参数：
            Object obj : 代表可以接收任意类型的对象
            String fieldName ： 代表该对象成员变量的名字

        返回值类型：
            Object : 代表该方法的返回值类型

        也就是说，该方法可以获取任意对象成员变量的值
        例如在测试类调用该方法：
            Person p = new Person("老罗");
            Object c = MyUtils.getProperty (p, "name");	//恭喜你，这个时候你就 得到 老罗了 ，接下来 你懂的~

        要求：必须使用反射
    */
    public static Object getProperty (Object obj, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field=obj.getClass().getField(fieldName);
        field.setAccessible(true);
        return field.get(obj);

    }
}
