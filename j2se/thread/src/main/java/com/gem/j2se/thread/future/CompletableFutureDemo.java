package com.gem.j2se.thread.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/15
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {
        //可以自定义线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        //runAsync的使用
        CompletableFuture<Void> runFuture = CompletableFuture.runAsync(() -> System.out.println("runFuture 自定义线程池"), executor);
        //supplyAsync的使用
        CompletableFuture<String> supplyFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyFuture 自定义线程池");
            return "返回值";
        }, executor);
        System.out.println(runFuture.join());
        System.out.println(supplyFuture.join());
        executor.shutdown();
    }
}
