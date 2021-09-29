package com.itheima.com.edu.day14;

public class Demo1 {
    public static void main(String[] args) {
        Demo1Thread1 demo1Thread1=new Demo1Thread1();
        Thread store1=new Thread(demo1Thread1);
        Thread website1=new Thread(demo1Thread1);
        store1.start();
        website1.start();
//
//        Demo1Thread2 demo1Thread2=new Demo1Thread2();
//        Thread store2=new Thread(demo1Thread2);
//        Thread website2=new Thread(demo1Thread2);
//        store2.start();
//        website2.start();

//        Demo1Thread3 demo1Thread3=new Demo1Thread3();
//        Thread store3=new Thread(demo1Thread3);
//        Thread website3=new Thread(demo1Thread3);
//        store3.start();
//        website3.start();



    }
}
