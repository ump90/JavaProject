package com.itheima.com.edu.day14;

import java.util.concurrent.locks.ReentrantLock;

public class Demo3Thread3 implements Runnable {
    private int number = 1000;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {


            lock.lock();

            try {
                if (number ==0) {

                    break;
                }

                Thread.sleep(3000);

                number--;
                System.out.println("剩余"+number+"张票");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        }

    }
}
