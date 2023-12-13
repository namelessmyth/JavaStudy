package com.gem.j2se.thread.CountDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch案例<br>
 * 主线程会等待子线程执行完毕之后才开始执行<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/13
 */
public class CountDownLatchDemo1 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        //计数器为3
        final CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("子线程" + Thread.currentThread().getName() + "开始执行");
                       TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                        System.out.println("子线程" + Thread.currentThread().getName() + "执行完成");
                        //执行完毕，计数器-1
                        latch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }

        try {
            System.out.println("主线程" + Thread.currentThread().getName() + "等待子线程执行完成...");
            //主线程等待直到计数器的值为0才会开始执行
            latch.await();
            System.out.println("主线程" + Thread.currentThread().getName() + "执行完毕");
            service.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
