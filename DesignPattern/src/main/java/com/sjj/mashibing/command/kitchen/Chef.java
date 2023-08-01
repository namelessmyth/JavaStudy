package com.sjj.mashibing.command.kitchen;

/**
 * 厨师类 -> Receiver角色
 **/
public class Chef {
    public void makeFood(int num, String foodName) {
        System.out.println(num + "份," + foodName);
    }
}
