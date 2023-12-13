package com.gem.j2se.thread.Semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Semaphore案例-停车场<br>
 * 停车场总共可以停的车数量是一定的<br>
 * 之前的车开走了，新的车才能进入停车场<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/13
 */
public class SemaphoreCar {
    /** 停车场允许最多容纳的车辆数：10 */
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        //模拟100辆车进入停车场
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        System.out.println("====" + Thread.currentThread().getName() + "来到停车场");
                        if (semaphore.availablePermits() == 0) {
                            System.out.println("停车位不足，请耐心等待");
                        }
                        //获取信号量-进入停车场
                        semaphore.acquire();
                        //模拟车辆在停车场停留的时间
                        System.out.println(Thread.currentThread().getName() + "成功进入停车场");
                        Thread.sleep(new Random().nextInt(10 * 1000));
                        System.out.println(Thread.currentThread().getName() + "驶出停车场");
                        //释放令牌，腾出停车场车位
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, i + "号车");
            thread.start();
        }
        //程序会等到所有的车进入停车场并离开之后才会退出
    }
}
