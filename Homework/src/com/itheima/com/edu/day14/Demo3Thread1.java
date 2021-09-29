package com.itheima.com.edu.day14;

public class Demo3Thread1 implements Runnable {
    private int number = 1000;
    private Object lock = new Object();

    @Override
    public void run() {

        while (true) {
            synchronized (lock) {
                if (number ==0) {
                    break;
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                number--;
                System.out.println("剩余"+number+"张票");

            }

        }


    }
}
