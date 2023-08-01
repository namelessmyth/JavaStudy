package com.sjj.mashibing.Singleton;

import java.io.Serializable;

/**
 * 懒汉式单例<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/17
 */
public class SingletonLasy implements Serializable {
    private static SingletonLasy instance;

    private SingletonLasy() {
        //私有构造方法
    }

    public static SingletonLasy getInstance() {
        if(instance == null){
            instance = new SingletonLasy();
        }
        return instance;
    }
}
