package com.sjj.mashibing.adapter.clazz;

/**
 * 目标（Target）接口-SD卡接口<br>
 */
public interface SDCard {
    //读取SD卡方法
    String readSD();
    //写入SD卡功能
    void writeSD(String msg);
}
