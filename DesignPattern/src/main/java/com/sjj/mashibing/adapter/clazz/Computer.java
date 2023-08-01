package com.sjj.mashibing.adapter.clazz;

/**
 * 电脑读写SD卡<br>
 */
public class Computer {
    public String read(SDCard sd){
        System.out.println("computer read sdcard.");
        return sd.readSD();
    }

    public void writer(SDCard sd,String data){
        System.out.println("computer write sdcard.");
        sd.writeSD(data);
    }
}
