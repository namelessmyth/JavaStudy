package com.sjj.mashibing.adapter.clazz;

/**
 * TF卡接口实现类<br>
 */
public class TFCardImpl implements TFCard {
    @Override
    public String readTF() {
        String msg = "tf card reading data";
        return msg;
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("tf card write data : " + msg);
    }
}
