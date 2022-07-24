package com.dk.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static int port = 8585;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            // 开始监听
            System.out.println("服务器开始监听，监听端口：" + port);
            while (true) {
                Socket accept = serverSocket.accept();// 阻塞
                System.out.println("接受到一个客户端的请求。。。");
                InputStream in = accept.getInputStream();
                int len = -1;
                byte[] buff = new byte[1024];
                while ((len = in.read(buff)) != -1) {
                    String str = new String(buff, 0, len);
                    System.out.println("读取到客户端输入字符：" + str);
                }
                in.close();
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
