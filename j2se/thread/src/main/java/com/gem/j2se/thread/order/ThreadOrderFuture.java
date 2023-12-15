package com.gem.j2se.thread.order;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使线程按顺序执行-Future<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/14
 */
public class ThreadOrderFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i <3; i++) {
            FutureTask task = new FutureTask(()->{
                System.out.println(Thread.currentThread().getName()+new Date());
                return "执行结束";
            });
            new Thread(task,"thread-"+i).start();
            //去掉下面这行代码，执行结果就是随机的
            task.get();
        }
    }
}
