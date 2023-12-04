package com.gem.j2se.thread.pool;

import java.util.concurrent.*;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/4
 */
public class PoolSequential {
    public static void singleThreadPool() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> System.out.println("t1..."));
        executor.submit(() -> System.out.println("t2..."));
        executor.submit(() -> System.out.println("t3..."));
        executor.shutdown();
    }

    public static void ScheduledExecutor() throws ExecutionException, InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Callable t1 = new Callable() {
            @Override
            public Long call() throws Exception {
                System.out.println("t1...");
                return 0L;
            }
        };
        ScheduledFuture<?> future1 = executor.schedule(t1, 0, TimeUnit.MILLISECONDS);
        Callable t2 = new Callable() {
            @Override
            public Long call() throws Exception {
                System.out.println("t2...");
                return 0L;
            }
        };
        //得到上一个线程的返回值之后再开始下一个线程
        ScheduledFuture<?> future2 = executor.schedule(t2, (Long) future1.get(), TimeUnit.MILLISECONDS);

        Callable t3 = new Callable() {
            @Override
            public Long call() throws Exception {
                System.out.println("t3...");
                return 0L;
            }
        };
        //得到上一个线程的返回值之后再开始下一个线程
        ScheduledFuture<?> future3 = executor.schedule(t3, (Long) future2.get(), TimeUnit.MILLISECONDS);
        executor.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        singleThreadPool();
        System.out.println("...");
        ScheduledExecutor();
    }
}
