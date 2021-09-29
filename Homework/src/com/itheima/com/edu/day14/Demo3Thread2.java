package com.itheima.com.edu.day14;

public class Demo3Thread2 implements Runnable {
    private int number = 1000;


    @Override
    public void run() {
        int sum = 0;
        while (true) {
            sum = sell(sum);
            if (number ==0) {
                break;
            }
            System.out.println("剩余"+number+"张票");

        }


    }

    public synchronized int sell(int sum) {
        if (number >0) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            number--;


        }

        return sum;
    }
}
