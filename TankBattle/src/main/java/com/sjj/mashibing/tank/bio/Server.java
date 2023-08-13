package com.sjj.mashibing.tank.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/13
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress("localhost", 8888));
        System.out.println("start...");
        //这个方法会一直阻塞，直到有连接进来。
        boolean started = true;
        while (started) {
            Socket s = ss.accept();
            //走到这里说明已经有连接进来了。
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //读取连接中传过来的数据。
            String line = br.readLine();
            //接收完客户端的数据才会释放和关闭。
            System.out.println("read:" + line);
            s.close();
            System.out.println("end...");
        }
    }
}
