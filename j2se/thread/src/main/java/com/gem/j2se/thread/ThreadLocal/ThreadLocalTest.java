package com.gem.j2se.thread.ThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/8
 */
public class ThreadLocalTest {
    public static ThreadLocal<Long> threadLocal = ThreadLocal.withInitial(() -> Thread.currentThread().getId());

    /**
     * 虽然threadLocal是定义在主线程中的，实际打印出来的值各不相同。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(threadLocal.get());
            }).start();
        }
        TimeUnit.SECONDS.sleep(5);
    }
}
