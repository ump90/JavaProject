package com.itheima.com.edu.day16.demo2;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket=new ServerSocket(10086);
    Socket socket=serverSocket.accept();
    BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(socket.getOutputStream());
    BufferedInputStream bufferedInputStream =new BufferedInputStream(socket.getInputStream());




  }
}


