package com.sjj.mashibing.Singleton;

import com.sjj.mashibing.adapter.clazz.Computer;

/**
 * 测试在多线程环境下，普通懒汉单例是否线程安全<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/29
 */
public class SingletonEnumThreadSafeTest implements Runnable {

    @Override
    public void run() {
        Computer instance = SingletonEnumLasy.one.getInstance();
        System.out.println(instance);
    }

    public static void main(String[] args) throws Exception {
        //SingletonLasy s1 = SingletonLasy.getInstance();
        //多线程下，下面的代码运行多次，会发现实例不是同一个。但上面的代码如果先执行，就不会破坏单例。
        Thread t1 = new Thread(new SingletonEnumThreadSafeTest());
        Thread t2 = new Thread(new SingletonEnumThreadSafeTest());
        Thread t3 = new Thread(new SingletonEnumThreadSafeTest());
        t1.start();
        t2.start();
        t3.start();
    }
}
