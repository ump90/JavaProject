package com.itheima.com.edu.day14;

import java.util.concurrent.ArrayBlockingQueue;

public class Demo5Cooker implements Runnable{
    private ArrayBlockingQueue<String> stringArrayBlockingQueue;

    public Demo5Cooker(ArrayBlockingQueue<String> stringArrayBlockingQueue) {
        this.stringArrayBlockingQueue = stringArrayBlockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                stringArrayBlockingQueue.put("food");
                System.out.println("produce food");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
