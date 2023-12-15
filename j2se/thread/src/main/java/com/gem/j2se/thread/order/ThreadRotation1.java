package com.gem.j2se.thread.order;

/**
 * 多个线程轮流打印1~100<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/14
 */
public class ThreadRotation1 {
    private static volatile int i = 1;
    private static volatile int flag = 0;

    public static void main(String [] args) throws Exception {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        Thread thread3 = new Thread(new Thread3());
        thread1.start();
        thread2.start();
        thread3.start();
    }
    public static class Thread1 implements Runnable {
        public void run() {
            while (i < 100) {
                if (flag == 0) {
                    System.out.println("t1=" + i);
                    i++;
                    flag = 1;
                }
            }
        }
    }
    public static class Thread2 implements Runnable {
        public void run() {
            while (i < 100) {
                if (flag == 1) {
                    System.out.println("t2=" + i);
                    i++;
                    flag = 2;
                }
            }
        }
    }
    public static class Thread3 implements Runnable {
        public void run() {
            while (i < 100) {
                if (flag == 2) {
                    System.out.println("t3=" + i);
                    i++;
                    flag = 0;
                }
            }
        }
    }
}
