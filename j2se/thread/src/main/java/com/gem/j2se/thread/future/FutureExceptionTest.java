package com.gem.j2se.thread.future;

import java.util.concurrent.CompletableFuture;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/15
 */
public class FutureExceptionTest {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> orgFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println("第一个任务:"+ Thread.currentThread().getName());
                    throw new RuntimeException();
                }
        );

        CompletableFuture<String> exceptionFuture = orgFuture.exceptionally((e) -> {
            e.printStackTrace();
            System.out.println("异常回调任务:"+ Thread.currentThread().getName());
            return "异常回调任务返回值";
        });

        System.out.println(exceptionFuture.get());
    }
}
