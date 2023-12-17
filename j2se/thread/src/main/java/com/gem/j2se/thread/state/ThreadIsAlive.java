package com.gem.j2se.thread.state;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/17
 */
public class ThreadIsAlive {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("t1 end");
            }
            System.out.println("t1 isAlive1:" + Thread.currentThread().isAlive());
        });

        Thread t2 = new Thread(() -> {
            synchronized (t1) {
                System.out.println("t2 begin");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                System.out.println("t2 end");
                System.out.println("t1 isAlive2:" + t1.isAlive());
            }
        });
        t1.start();
        t2.start();
        t1.join();
        System.out.println("t1 isAlive3:" + t1.isAlive());
    }
}
