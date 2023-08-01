package com.sjj.mashibing.flyweight.gobang;

/**
 * 抽象享元类: 五子棋类
 * @author spikeCong
 * @date 2022/10/10
 **/
public abstract class GobangFlyweight {

    public abstract String getColor();

    public void display(){
        System.out.println("棋子颜色: " + this.getColor());
    }
}
