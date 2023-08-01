package com.sjj.mashibing.state.TrafficLight;

/**
 * 黄灯状态类
 **/
public class Yellow implements State {

    @Override
    public void switchToGreen(TrafficLight trafficLight) {
        System.out.println("绿灯亮起...时长:60秒!");
    }

    @Override
    public void switchToYellow(TrafficLight trafficLight) {
        System.out.println("已是黄灯无须切换!");
    }

    @Override
    public void switchToRed(TrafficLight trafficLight) {
        System.out.println("红灯亮起...时长:90秒!");
    }
}
