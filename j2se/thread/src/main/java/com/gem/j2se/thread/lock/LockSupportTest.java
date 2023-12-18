package com.gem.j2se.thread.lock;

import java.util.Date;
import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport-使用案例<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/18
 */
public class LockSupportTest {
    public static Object u = new Object();

    public static void main(String[] args) throws InterruptedException {
        ChangeObjectThread t1 = new ChangeObjectThread("t1");
        t1.start();
        Thread.sleep(1000L);

        ChangeObjectThread t2 = new ChangeObjectThread("t2");
        t2.start();
        Thread.sleep(2000L);

        System.out.println("主线程中断t1。" + new Date());
        t1.interrupt();

        System.out.println("主线程unparkt2。" + new Date());
        LockSupport.unpark(t2);

        System.out.println("主线程等待t1 t2。" + new Date());
        t1.join();
        t2.join();
    }

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println(getName() + "开始park。" + new Date());
                LockSupport.park();
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(getName() + "被中断了。" + new Date());
                }
                System.out.println(getName() + "继续执行。"+ new Date());
            }
        }
    }
}
