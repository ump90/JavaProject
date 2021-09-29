package com.itheima.com.edu.day17;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Person {
  private String name;
  private int age;

  public Person() {}

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void run() {
    System.out.println("我" + name + "是一个好人");
  }

  public void show(Date date) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
    System.out.println(simpleDateFormat.format(date));
  }
  public void copy(String fileName) throws IOException {
    BufferedReader bufferedReader=new BufferedReader(new FileReader(fileName));
    ArrayList<String> arrayList=new ArrayList<>();
    String tmp;
    while ((tmp=bufferedReader.readLine())!=null){
      arrayList.add(tmp);
    }
    BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(fileName));
    for (int i = 0; i < arrayList.size(); i++) {
      bufferedWriter.write(arrayList.get(arrayList.size()-i-1));
    }
    bufferedReader.close();
    bufferedWriter.close();
  }
}
