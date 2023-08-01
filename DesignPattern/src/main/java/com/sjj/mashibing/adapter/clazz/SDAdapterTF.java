package com.sjj.mashibing.adapter.clazz;

/**
 * 类适配器（Adapter）类-TF卡转SD卡类<br>
 */
public class SDAdapterTF extends TFCardImpl implements SDCard {
    @Override
    public String readSD() {
        System.out.println("adapter read tf card ");
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        writeTF(msg);
    }
}
