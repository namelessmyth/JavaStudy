package com.gem.j2se.thread.order;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

/**
 * 使线程按顺序执行-CompletableFuture<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/14
 */
public class ThreadOrderCompletableFuture {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(new MyTask("T1")).thenRun(new MyTask("T2")).thenRun(new MyTask("T3"));
        future.get();
        //下面2种方式也可以
        get();
        join();
    }

    public static void get() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(new MyTask("T1"));
        future.get();

        future = CompletableFuture.runAsync(new MyTask("T2"));
        future.get();

        future = CompletableFuture.runAsync(new MyTask("T3"));
        future.get();
    }

    public static void join() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(new MyTask("T1"));
        future.join();

        future = CompletableFuture.runAsync(new MyTask("T2"));
        future.join();

        future = CompletableFuture.runAsync(new MyTask("T3"));
        future.join();
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
