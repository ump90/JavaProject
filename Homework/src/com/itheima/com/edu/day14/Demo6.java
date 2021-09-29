package com.itheima.com.edu.day14;

import java.util.concurrent.locks.ReentrantLock;

public class Demo6 {
    public static void main(String[] args) {
        ReentrantLock lock1=new ReentrantLock();
        ReentrantLock lock2=new ReentrantLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(lock1.tryLock()){
                        try{
                            if(lock2.tryLock()){
                                try {
                                    System.out.println("T1执行");
                                }finally {
                                    lock2.unlock();
                                }

                            }

                        }finally {
                            lock1.unlock();
                        }
                    }


                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(lock2.tryLock()){
                        try{
                            if(lock1.tryLock()){
                                try {
                                    System.out.println("T2执行");
                                }finally {
                                    lock1.unlock();
                                }

                            }

                        }finally {
                            lock2.unlock();
                        }
                    }


                }

            }
        }).start();
    }
}
