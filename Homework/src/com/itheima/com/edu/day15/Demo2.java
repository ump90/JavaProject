package com.itheima.com.edu.day15;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Demo2 {
  public static void main(String[] args) {
    int number=100;
    GenerateTicket generateTicket=new GenerateTicket(number);
    Thread thread1=new Thread(generateTicket);
    Thread thread2=new Thread(generateTicket);
    thread1.start();
    thread2.start();
  }
}

class GenerateTicket implements Runnable {
  private int number;
  private int totalNumber;
  private ReentrantLock lock=new ReentrantLock();

  public GenerateTicket(int number) {
    this.number = number;
    this.totalNumber=this.number;
  }

  @Override
  public void run() {
    while (true) {

      if(number>0){
        lock.lock();
        number--;
        lock.unlock();
      }else {
        break;
      }

      LinkedHashSet<Integer> integerHashSet = new LinkedHashSet<>();
      Random random = new Random();
      while (integerHashSet.size() != 6) {
        integerHashSet.add(random.nextInt(33)+1);
      }
      ArrayList<Integer> initialarraylist=new ArrayList<>(integerHashSet);
      initialarraylist.add(random.nextInt(16)+1);
      System.out.println("编号为: "+(totalNumber-number)+"的员工 从后门 入场! 拿到的双色球彩票号码是:"+initialarraylist);
    }
  }
}
