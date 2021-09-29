package com.itheima.com.edu.day14;

import java.util.concurrent.locks.ReentrantLock;

public class Demo2Thread3 implements Runnable {
    private int number = 100;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        int sum=0;

        while (true) {


            lock.lock();

            try {
                if (number < 10) {
                    System.out.println(Thread.currentThread().getName() + " have send " + sum+" gifts");
                    break;
                }

                Thread.sleep(50);

                number--;
                sum++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        }

    }
}
