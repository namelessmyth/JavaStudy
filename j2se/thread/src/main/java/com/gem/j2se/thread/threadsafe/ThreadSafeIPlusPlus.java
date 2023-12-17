package com.gem.j2se.thread.threadsafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使i++线程安全<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/16
 */
public class ThreadSafeIPlusPlus {
    public static void main(String[] args) throws Exception {
        //使用AtomicInteger
        AtomicInteger i = new AtomicInteger(0);
        //i++
        i.getAndIncrement();
        //++i
        i.incrementAndGet();
        System.out.println(i);

        //使用synchronized
        int i1 = 0;
        synchronized (ThreadSafeIPlusPlus.class) {
            i1++;
        }

        //使用lock
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        try {
            i1++;
        } finally {
            lock.unlock();
        }
    }
}
