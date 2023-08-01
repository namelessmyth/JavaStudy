package com.sjj.mashibing.decorator.DataLoader;

/**
 * 装饰器模式-抽象构件（Component）角色<br>
 */
public interface DataLoader {
    String read();
    void write(String data);
}
