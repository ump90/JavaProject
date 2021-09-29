package com.itheima.com.edu.day14;

import java.util.concurrent.ArrayBlockingQueue;

public class Demo5 {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrayBlockingQueue=new ArrayBlockingQueue<>(1);
        new Thread(new Demo5Cooker(arrayBlockingQueue)).start();
        new Thread(new Demo5Eater(arrayBlockingQueue)).start();



    }
}
