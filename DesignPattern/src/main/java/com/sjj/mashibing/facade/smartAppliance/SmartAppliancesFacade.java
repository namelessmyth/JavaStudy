package com.sjj.mashibing.facade.smartAppliance;

/**
 * 外观角色：智能家电<br>
 */
public class SmartAppliancesFacade {

    private Light light;
    private TV tv;
    private AirCondition airCondition;

    public SmartAppliancesFacade() {
        this.light =new Light();
        this.tv = new TV();
        this.airCondition = new AirCondition();
    }

    public void say(String message){
        if(message.contains("打开家电")){
            on();
        }else if(message.contains("关闭家电")){
            off();
        }else{
            System.out.println("对不起没有听清楚您说什么! 请重新再说一遍");
        }
    }


    //起床后 语音开启 电灯 电视 空调
    private void on() {
        System.out.println("起床了!");
        light.on();
        tv.on();
        airCondition.on();
    }

    //睡觉前 语音关闭 电灯 电视 空调
    private void off() {
        System.out.println("睡觉了!");
        light.off();
        tv.off();
        airCondition.off();
    }
}
