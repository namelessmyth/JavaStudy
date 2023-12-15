package com.gem.j2se.thread.order;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使线程按顺序执行-单线程线程池<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/14
 */
public class ThreadOrderSinglePool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 3; i++) {
            executor.submit(new MyTask("thread-" + i));
        }
        executor.shutdown();
    }

    static class MyTask implements Runnable {
        String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(this.name + ": " + new Date());
        }
    }
}
