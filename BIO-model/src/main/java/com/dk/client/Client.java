package com.dk.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static int port = 8585;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入客户端编号：");

        int no = sc.nextInt();
        Socket socket = null;
        try {
            System.out.println("客户端" + no + "开始连接服务器。。。");
            socket = new Socket("127.0.0.1", port);
            if (socket != null) {
                System.out.println("客户端：" + no + "连接服务器成功");
            }
            OutputStream outputStream = socket.getOutputStream();

            while (true) {
                System.out.println("客户端" + no + "请输入要发送字符(输入quit表示结束)");
                String next = sc.next();
                if (next.trim().equalsIgnoreCase("quit"))
                    break;
                outputStream.write((no + ":" + next).getBytes());
            }
            System.out.println("客户" + no + "连接中断");
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
