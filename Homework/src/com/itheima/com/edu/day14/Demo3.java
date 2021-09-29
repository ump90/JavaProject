package com.itheima.com.edu.day14;

public class Demo3 {
    public static void main(String[] args) {
        Demo3Thread1 demo3Thread1=new Demo3Thread1();
        Thread windows1=new Thread(demo3Thread1);
        Thread windows2=new Thread(demo3Thread1);
        windows1.start();
        windows2.start();

        Demo3Thread2 demo3Thread2=new Demo3Thread2();
        Thread windows3=new Thread(demo3Thread2);
        Thread windows4=new Thread(demo3Thread2);
        windows3.start();
        windows4.start();

        Demo3Thread3 demo3Thread3=new Demo3Thread3();
        Thread windows5=new Thread(demo3Thread3);
        Thread windows6=new Thread(demo3Thread3);
        windows5.start();
        windows6.start();



    }
}
