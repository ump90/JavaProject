package com.itheima.com.edu.day14;

public class Demo1Thread1 implements Runnable {
    private int number = 100;
    private Object lock = new Object();

    @Override
    public void run() {
        int sum=0;

        while (true) {
            synchronized (lock) {
                if (number == 0) {
                    break;
                }
                number--;
                sum++;
            }

        }
        System.out.println(Thread.currentThread().getName() + " have sold" + sum);

    }
}
