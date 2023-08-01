package com.sjj.mashibing.Singleton;

import sun.security.jca.GetInstance;

/**
 * 饿汉式单例模式<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/17
 */
public class SingletonHungry {
    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {
        //私有构造方法
    }

    public static SingletonHungry getInstance() {
        return instance;
    }
}
