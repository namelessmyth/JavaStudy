package com.sjj.mashibing.Singleton;

/**
 * 懒汉单例模式-静态内部类<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/17
 */
public class SingletonStaticInner {

    private SingletonStaticInner() {
    }

    private static class SingletonStaticInnerHolder {
        private static volatile SingletonStaticInner instance;
    }

    public static SingletonStaticInner getInstance() {
        return SingletonStaticInnerHolder.instance;
    }
}
