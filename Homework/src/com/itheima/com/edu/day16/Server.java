package com.itheima.com.edu.day16;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(10086);

    ThreadPoolExecutor threadPoolExecutor =
        new ThreadPoolExecutor(
            2,
            4,
            2,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(5),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());
    while (true) {
      Socket socket=serverSocket.accept();
      Thread1 thread1=new Thread1(socket);
      threadPoolExecutor.submit(thread1);
    }
  }
}

class Thread1 implements Runnable {
  private Socket socket;

  public Thread1(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      BufferedOutputStream bos =
          new BufferedOutputStream(new FileOutputStream("D:\\" + UUID.randomUUID()));
      BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
      int by;
      byte[] bytes = new byte[8196];
      while ((by = bis.read(bytes)) != -1) {
        bos.write(bytes, 0, by);
      }
      BufferedOutputStream bos2=new BufferedOutputStream(socket.getOutputStream());
      String back="The file has been received";
      bos2.write(back.getBytes(StandardCharsets.UTF_8));
      bos2.close();
      bis.close();
      bos.close();

      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
