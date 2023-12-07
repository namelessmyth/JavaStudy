package com.gem.j2se.thread.pool;

import cn.hutool.core.thread.NamedThreadFactory;
import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 自定义ThreadFactory案例<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/6
 */
public class ThreadFactoryTest {
    public static ExecutorService NamedExecutor1(String[] args) throws Exception {
        //自己创建ThreadFactory
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNamePrefix("gem-test-").setDaemon(false).setPriority(Thread.NORM_PRIORITY).build();
        ExecutorService executorService = Executors.newFixedThreadPool(2, threadFactory);
        return executorService;
    }

    public static ThreadPoolExecutor NamedExecutor2() {
        //使用Hutool的ThreadFactory
        return new ThreadPoolExecutor(10, 30, 60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000), new NamedThreadFactory("gem-test", false));
    }

    public static ExecutorService NamedExecutor3(String[] args) throws Exception {
        //自己创建ThreadFactory
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                //要把任务Runnable设置给新创建的线程
                Thread thread = new Thread(r);
                //设置线程的命名规则
                thread.setName("我的线程" + r.hashCode());
                //设置线程的优先级
                thread.setPriority(Thread.MAX_PRIORITY);
                return thread;
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2, threadFactory);
        return executorService;
    }
}
