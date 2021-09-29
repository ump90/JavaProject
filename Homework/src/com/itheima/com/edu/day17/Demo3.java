package com.itheima.com.edu.day17;

import java.util.*;

public class Demo3 {
  public static void main(String[] args) {
    ArrayList<Integer> arrayList = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < 10; i++) {
      arrayList.add(random.nextInt(101));
    }
    Collections.sort(arrayList);


    arrayList.forEach(
        s -> {
          System.out.println(s);
        });
    String s1="109";
    arrayList.add(Integer.parseInt(s1));
  }
}
