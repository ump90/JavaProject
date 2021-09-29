package com.itheima.com.edu.day16;

import java.io.*;

import java.net.Socket;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) throws IOException {

    Scanner scanner = new Scanner(System.in);
    Socket socket = new Socket("127.0.0.1", 10086);
    Scanner sc = new Scanner(System.in);
    System.out.println("Please input the path of the file.");
    String path = sc.nextLine();
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
    BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
    int b;
    byte[] bytes = new byte[8196];
    while ((b = bis.read(bytes)) != -1) {
      bos.write(bytes, 0, b);
    }
    bos.flush();
    socket.shutdownOutput();
    System.out.println("Send file complete");
    BufferedReader bufferedReader =
        new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String information;
    while ((information = bufferedReader.readLine()) != null) {
      System.out.println(information);
    }
    bos.close();
    bis.close();
    socket.close();
  }
}
