package com.sjj.mashibing.adapter.clazz;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/30/0030
 */
public class SDCardImpl implements SDCard {
    @Override
    public String readSD() {
        String msg = "sd card reading data";
        return msg;
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("sd card write data : " + msg);
    }
}
