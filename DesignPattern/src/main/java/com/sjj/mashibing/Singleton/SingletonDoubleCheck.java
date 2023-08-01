package com.sjj.mashibing.Singleton;

/**
 * 懒汉单例模式-双重检查锁单例<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/17
 */
public class SingletonDoubleCheck {
    private static volatile SingletonDoubleCheck instance;

    private SingletonDoubleCheck() {}

    public static SingletonDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleCheck.class) {

                if (instance == null) {
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}
