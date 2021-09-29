package com.itheima.com.edu.day18;

public class Hello {
  @AnnocationTest
  public void hello1() {
    System.out.println("hello1");
  }

  @AnnocationTest
  public void hello2() {
    System.out.println("hello2");
  }

  @AnnocationTest
  public void hello3() {
    int[] test = new int[8];
    System.out.println(test[9]);
  }
}
