package com.itheima.com.edu.day14;

import java.util.concurrent.ArrayBlockingQueue;

public class Demo5Eater implements Runnable{
    private ArrayBlockingQueue<String> stringArrayBlockingQueue;

    public Demo5Eater(ArrayBlockingQueue<String> stringArrayBlockingQueue) {
        this.stringArrayBlockingQueue = stringArrayBlockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                stringArrayBlockingQueue.take();
                System.out.println("eat food");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
