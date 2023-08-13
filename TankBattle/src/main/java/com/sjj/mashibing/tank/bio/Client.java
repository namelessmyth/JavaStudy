package com.sjj.mashibing.tank.bio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost",8888);
        //走到这里说明tcp连接已经建立上。
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bw.write("hello server..");
        bw.flush();
        bw.close();
        s.close();
    }
}
