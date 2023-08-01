package com.sjj.mashibing.state.TrafficLight;

/**
 * 上下文信息类-交通灯类 <br>
 *    红灯(禁行) ,黄灯(警示),绿灯(通行) 三种状态.<br>
 **/
public class TrafficLight {

    //初始状态红灯
    State state = new Red();

    public void setState(State state) {
        this.state = state;
    }

    //切换为绿灯状态
    public void switchToGreen(){
        state.switchToGreen(this);
    }

    //切换为黄灯状态
    public void switchToYellow(){
        state.switchToYellow(this);
    }

    //切换为红灯状态
    public void switchToRed(){
        state.switchToRed(this);
    }
}
