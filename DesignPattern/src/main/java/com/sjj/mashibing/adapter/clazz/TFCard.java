package com.sjj.mashibing.adapter.clazz;

/**
 * 适配者（Adaptee）类-TF卡接口<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/30/0030
 */
public interface TFCard {
    //读取TF卡方法
    String readTF();
    //写入TF卡功能
    void writeTF(String msg);
}
