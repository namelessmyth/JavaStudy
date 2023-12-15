package com.gem.j2se.thread.ThreadLocal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 父子线程-数据共享-Map<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/8
 */
public class ParentChildMap {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread(new ConcurrentHashMap<String, String>());
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("main thread previous: " + thread.sharedData.get("key"));
        thread.sharedData.put("key", "value");
        System.out.println("main thread after: " + thread.sharedData.get("key"));
    }

    static class MyThread extends Thread {
        ConcurrentHashMap<String, String> sharedData = null;

        public MyThread(ConcurrentHashMap<String, String> sharedData) {
            this.sharedData = sharedData;
        }

        @Override
        public void run() {
            //子线程这个地方没有初始化过，所以会空指针
            System.out.println("child thread previous: " + sharedData.get("key"));
            sharedData.put("key", "new value");
            System.out.println("child thread after: " + sharedData.get("key"));
        }
    }
}
