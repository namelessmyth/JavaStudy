package com.gem.j2se.thread.future;

import java.util.concurrent.CompletableFuture;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/15
 */
public class FutureThenApplyTest {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> orgFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println("第一个任务");
                    return "第一个任务返回值";
                }
        );

        CompletableFuture<String> thenAcceptFuture = orgFuture.thenApply((a) -> {
            if ("第一个任务返回值".equals(a)) {
                System.out.println("满足条件，第二个任务已执行");
            } else {
                System.out.println("不满足条件，第二个任务未执行");
            }
            return "第二个任务返回值";
        });
        System.out.println(thenAcceptFuture.get());
    }
}
