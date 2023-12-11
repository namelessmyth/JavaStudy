package com.gem.j2se.thread.deamon;

import java.util.concurrent.TimeUnit;

/**
 * 守护线程退出-演示代码<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/8
 */
public class DeamonExit {
    /**
     * 此方法只会打印一遍守护线程中的内容就会退出。因为jvm不会等守护线程执行完毕才退出。
     * 但如果把 childThread.setDaemon(true);注释就会一直执行
     * @param args
     */
    public static void main(String[] args) {
        Thread childThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 1000; i++) {
                        System.out.println("I'm a Deamon thread:" + i);
                        TimeUnit.SECONDS.sleep(1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        childThread.setDaemon(true);
        childThread.start();
        System.out.println("I'm a main thread...");
    }
}
