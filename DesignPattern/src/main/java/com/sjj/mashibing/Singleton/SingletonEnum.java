package com.sjj.mashibing.Singleton;

public enum SingletonEnum {
    instance;

    public SingletonEnum getInstance(){
        return instance;
    }
}
