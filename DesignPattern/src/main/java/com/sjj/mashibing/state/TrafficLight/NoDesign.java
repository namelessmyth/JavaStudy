package com.sjj.mashibing.state.TrafficLight;

/**
 * 交通信号灯切换-不用设计模式实现<br>
 * 红灯(禁行) ,黄灯(警示),绿灯(通行) 三种状态.<br>
 */
public class NoDesign {
    //初始状态红灯
    private String state = "红";

    //切换为绿灯(通行)状态
    public void switchToGreen() {
        if ("绿".equals(state)) {//当前是绿灯
            System.out.println("当前为绿灯状态,无需切换!");
        } else if ("红".equals(state)) {
            System.out.println("红灯不能切换为绿灯!");
        } else if ("黄".equals(state)) {
            state = "绿";
            System.out.println("绿灯亮起...时长: 60秒");
        }
    }

    //切换为黄灯(警示)状态
    public void switchToYellow() {
        if ("黄".equals(state)) {//当前是黄灯
            System.out.println("当前为黄灯状态,无需切换!");
        } else if ("红".equals(state) || "绿".equals(state)) {
            state = "黄";
            System.out.println("黄灯亮起...时长:10秒");
        }
    }

    //切换为黄灯(警示)状态
    public void switchToRed() {
        if ("红".equals(state)) {//当前是绿灯
            System.out.println("当前为红灯状态,无需切换!");
        } else if ("绿".equals(state)) {
            System.out.println("绿灯不能切换为红灯!");
        } else if ("黄".equals(state)) {
            state = "红";
            System.out.println("红灯亮起...时长: 90秒");
        }
    }
}
