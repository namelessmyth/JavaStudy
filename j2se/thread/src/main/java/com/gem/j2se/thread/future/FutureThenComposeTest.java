package com.gem.j2se.thread.future;

import java.util.concurrent.CompletableFuture;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/15
 */
public class FutureThenComposeTest {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> a = CompletableFuture.supplyAsync(() -> {
            System.out.println("第一个任务：" + Thread.currentThread().getName());
            return "第一个任务返回值";
        });
        CompletableFuture<String> b = a.thenCompose(result -> CompletableFuture.supplyAsync(() -> {
            System.out.println("第二个任务：" + Thread.currentThread().getName());
            return result+", 第二个任务返回值";
        }));
        CompletableFuture<String> c = b.thenCompose(result -> CompletableFuture.supplyAsync(() -> {
            System.out.println("第三个任务：" + Thread.currentThread().getName());
            return result+", 第三个任务返回值";
        }));
        System.out.println(c.join());
    }
}
