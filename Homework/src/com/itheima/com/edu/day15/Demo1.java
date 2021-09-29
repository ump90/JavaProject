package com.itheima.com.edu.day15;

import java.util.*;

public class Demo1 {
  public static void main(String[] args) {
    Object lock=new Object();

    int[] ticket = {10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700};
    LinkedHashSet<Integer> integerHashSet = new LinkedHashSet<>();

    Random random = new Random();
    while (integerHashSet.size() != ticket.length) {
      integerHashSet.add(random.nextInt(ticket.length));
    }
    Integer[] ticketindex = new Integer[integerHashSet.size()];
    integerHashSet.toArray(ticketindex);
    int[] newticket = new int[integerHashSet.size()];
    for (int i = 0; i < ticketindex.length; i++) {
      newticket[ticketindex[i]] = ticket[i];
    }
    int index = ticketindex.length-1;

    thread thread = new thread(index, newticket,lock);
    Thread thread1 = new Thread(thread);
    Thread thread2 = new Thread(thread);
    thread1.setName("Tom");
    thread2.setName("Bob");
    thread1.start();
    thread2.start();
  }
}

class thread implements Runnable {
  private int index;
  private int[] list;
  private Object lock;

  public thread(int index, int[] list,Object lock) {
    this.index = index;
    this.list = list;
    this.lock=lock;
  }

  @Override
  public void run() {

    while (true) {
      synchronized (lock){
        if(index>=0){
          System.out.println(Thread.currentThread().getName() + "又产生了一个" + list[index] + "元大奖");
          index--;
        }else {
          break;
        }
      }
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }


    }
  }
}
