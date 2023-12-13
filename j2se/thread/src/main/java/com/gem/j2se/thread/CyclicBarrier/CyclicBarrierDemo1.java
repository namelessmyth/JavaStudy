package com.gem.j2se.thread.CyclicBarrier;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrier案例-大巴车人满发车<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/13
 */
public class CyclicBarrierDemo1 {
    public static void main(String[] args) {
        // 创建大巴车，人数到达2就发车
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("人满了，准备发车：" + new Date());
            }
        });

        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            threadPool.submit(() -> {
                // 进入任务
                try {
                    // 模拟不同的人不同时间上车
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                    // 任务执行
                    System.out.println(String.format("线程：%s 上车，到达时间：%s",
                            Thread.currentThread().getName(), new Date()));
                    // 到达后在栅栏处等待。
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        // 等待所有任务执行完终止线程池
        threadPool.shutdown();
    }
}
