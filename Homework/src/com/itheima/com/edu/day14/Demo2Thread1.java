package com.itheima.com.edu.day14;

public class Demo2Thread1 implements Runnable {
    private int number = 100;
    private Object lock = new Object();

    @Override
    public void run() {
        int sum=0;

        while (true) {
            synchronized (lock) {
                if (number < 10) {
                    break;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                number--;
                sum++;
            }

        }
        System.out.println(Thread.currentThread().getName() + " have send" + sum+" gifts");

    }
}
