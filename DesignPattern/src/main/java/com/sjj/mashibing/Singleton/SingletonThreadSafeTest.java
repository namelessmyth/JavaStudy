package com.sjj.mashibing.Singleton;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 测试在多线程环境下，普通懒汉单例是否线程安全<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/29
 */
public class SingletonThreadSafeTest implements Runnable {

    @Override
    public void run() {
        SingletonLasy instance = SingletonLasy.getInstance();
        System.out.println(instance);
    }

    public static void main(String[] args) throws Exception {
        //SingletonLasy s1 = SingletonLasy.getInstance();
        //多线程下，下面的代码运行多次，会发现实例不是同一个。但上面的代码如果先执行，就不会破坏单例。
        Thread t1 = new Thread(new SingletonThreadSafeTest());
        Thread t2 = new Thread(new SingletonThreadSafeTest());
        Thread t3 = new Thread(new SingletonThreadSafeTest());
        t1.start();
        t2.start();
        t3.start();
    }
}
