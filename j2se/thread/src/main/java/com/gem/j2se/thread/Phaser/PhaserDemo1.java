package com.gem.j2se.thread.Phaser;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Phaser案例<br>
 * 当所有注册线程到齐之后，每个线程才会继续执行。
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/13
 */
public class PhaserDemo1 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        for (int i = 0; i < 3; i++) {
            // 注册每个线程，所有注册的线程到齐之后才会继续。
            phaser.register();
            new Thread(new Task(phaser), "Thread-" + i).start();
        }
        System.out.println(Thread.currentThread().getName() + ": 主线程执行，时间 =" + new Date());
    }
}

class Task implements Runnable {
    private final Phaser phaser;

    Task(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
            System.out.println(Thread.currentThread().getName() + ": 已到达，时间 =" + new Date());
            // 等待其它参与者线程到达
            int i = phaser.arriveAndAwaitAdvance();
            // do something
            System.out.println(Thread.currentThread().getName() + ": 已到齐继续，时间 =" + new Date());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
