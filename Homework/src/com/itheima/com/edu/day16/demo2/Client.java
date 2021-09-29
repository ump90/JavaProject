package com.itheima.com.edu.day16.demo2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.UUID;

public class Client {
  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("127.0.0.1", 10086);
    System.out.println("Please select the file:");
    DataCenter.clientMap.forEach(
        (key, value) -> System.out.println(key + "->" + value));
    Scanner scanner = new Scanner(System.in);
    String key = scanner.nextLine();
    BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(socket.getOutputStream());
    BufferedInputStream bufferedInputStream=new BufferedInputStream(socket.getInputStream());
    BufferedOutputStream bos =new BufferedOutputStream(new FileOutputStream(UUID.randomUUID()+".txt"));
    bufferedOutputStream.write(key.getBytes(StandardCharsets.UTF_8));
    bufferedOutputStream.flush();
    int by;
    byte [] bytes=new byte[8196];
    while((by=bufferedInputStream.read(bytes))!=-1){
      bos.write(bytes, 0, by);
    }
    bos.flush();
    System.out.println("The file has been saved.");
    bufferedOutputStream.close();
    bufferedInputStream.close();
    bos.close();
    socket.close();


  }
}
