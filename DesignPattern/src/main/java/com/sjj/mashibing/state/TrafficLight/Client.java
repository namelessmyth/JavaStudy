package com.sjj.mashibing.state.TrafficLight;

public class Client {

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.switchToYellow();
        trafficLight.switchToGreen();
        trafficLight.switchToRed();
    }
}
