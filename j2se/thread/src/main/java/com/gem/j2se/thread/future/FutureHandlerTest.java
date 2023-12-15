package com.gem.j2se.thread.future;

import java.util.concurrent.CompletableFuture;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/15
 */
public class FutureHandlerTest {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> orgFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println("第一个任务：" + Thread.currentThread().getName());
                    return "第一个任务返回值";
                }
        );

        CompletableFuture<String> rstFuture = orgFuture.handle((a, throwable) -> {
            System.out.println("whenComplete任务：" + Thread.currentThread().getName());
            System.out.println("上个任务返回值：" + a);
            System.out.println("上个任务异常：" + throwable);
            return "回调方法返回值";
        });

        System.out.println(rstFuture.get());
    }
}
