package com.sjj.mashibing.flyweight.gobang;

/**
 * 共享享元类-白色棋子
 * @author spikeCong
 * @date 2022/10/10
 **/
public class WhiteGobang extends GobangFlyweight{

    @Override
    public String getColor() {
        return "白色";
    }
}
