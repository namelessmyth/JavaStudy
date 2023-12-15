package com.gem.j2se.thread.ThreadLocal;

/**
 * 父子间数据传递错误案例<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/8
 */
public class ThreadLocalParentChildError {
    public static ThreadLocal<Integer> sharedData = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        sharedData.set(0);
        MyThread thread = new MyThread();
        thread.start();
        sharedData.set(sharedData.get() + 1);
        System.out.println("sharedData in main thread: " + sharedData.get());
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("sharedData in child thread: " + sharedData.get());
            //子线程这个地方没有初始化过，所以会空指针
            sharedData.set(sharedData.get() + 1);
            System.out.println("sharedData in child thread after increment: " + sharedData.get());
        }
    }
}
