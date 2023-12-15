package com.gem.j2se.thread.order;

import java.util.Date;

/**
 * 使线程按顺序执行-join<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/14
 */
public class ThreadOrderJoin {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <3; i++) {
            Thread t = new Thread(()->{
                System.out.println(Thread.currentThread().getName()+new Date());
            },"thread-"+i);
            t.start();
            //去掉下面这行代码，执行结果就是随机的
            t.join();
        }
    }
}
