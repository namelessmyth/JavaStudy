package com.sjj.mashibing.Singleton;

import com.sjj.mashibing.adapter.clazz.Computer;

/**
 * 枚举局部单例-懒加载
 */
public enum SingletonEnumLasy {
    one;
    Computer instance;

    SingletonEnumLasy(){
        instance = new Computer();
    }

    public Computer getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Computer s1 = SingletonEnumLasy.one.getInstance();
        Computer s2 = SingletonEnumLasy.one.getInstance();
        System.out.println(s1==s2);
    }
}
