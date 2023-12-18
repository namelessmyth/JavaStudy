package com.gem.j2se.thread.ThreadBase;

import java.util.Date;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/18
 */
public class WaitNotifyTest1 {
    static Object object = new Object();

    public static void main(String[] args) {
        System.out.println("开始测试。" + new Date());
        new Thread(() -> {
            synchronized (object) {
                System.out.println("线程 A：已获得锁。" + new Date());
                try {
                    System.out.println("线程 A：准备wait。" + new Date());
                    object.wait();
                    System.out.println("线程 A：重新获取到锁，继续执行。" + new Date());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程 A：结束。" + new Date());
            }
        }, "线程 A。").start();

        new Thread(() -> {
            try {
                System.out.println("线程 B：先睡会。" + new Date());
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
                System.out.println("线程 B：nofiry A begin。" + new Date());
                object.notify();
                System.out.println("线程 B：nofiry A end。" + new Date());
                try {
                    // 试验执行完 notify() 方法后，A 线程是否能立即获取到锁
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程 B：结束。" + new Date());
            }
        }, "线程 B").start();
        System.out.println("主线程：结束。" + new Date());
    }
}
