package com.itheima.com.edu.day14;

public class Demo2 {
    public static void main(String[] args) {
        Demo2Thread1 demo2Thread1=new Demo2Thread1();
        Thread people1=new Thread(demo2Thread1);
        Thread people2=new Thread(demo2Thread1);
        people1.start();
        people2.start();

        Demo2Thread2 demo2Thread2=new Demo2Thread2();
        Thread people3=new Thread(demo2Thread2);
        Thread people4=new Thread(demo2Thread2);
        people3.start();
        people4.start();

        Demo2Thread3 demo2Thread3=new Demo2Thread3();
        Thread people5=new Thread(demo2Thread3);
        Thread people6=new Thread(demo2Thread3);
        people5.start();
        people6.start();



    }
}
