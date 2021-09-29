package com.itheima.com.edu.day14;

public class Demo1Thread2 implements Runnable {
    private int number = 100;


    @Override
    public void run() {
        int sum = 0;
        while (true) {
            sum = sell(sum);
            if (number == 0) {
                break;
            }

        }
        System.out.println(Thread.currentThread().getName() + " have sold" + sum);

    }

    public synchronized int sell(int sum) {
        if (number == 0) {
            ;

        } else {
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
