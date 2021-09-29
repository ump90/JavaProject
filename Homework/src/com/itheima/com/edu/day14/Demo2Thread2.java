package com.itheima.com.edu.day14;

public class Demo2Thread2 implements Runnable {
    private int number = 100;


    @Override
    public void run() {
        int sum = 0;
        while (true) {
            sum = sell(sum);
            if (number < 10) {
                break;
            }

        }
        System.out.println(Thread.currentThread().getName() + " have send " + sum+" gifts");

    }

    public synchronized int sell(int sum) {
        if (number >=10) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            number--;
            sum++;

        }

        return sum;
    }
}
