package com.sjj.mashibing.adapter.instance;

import com.sjj.mashibing.adapter.clazz.SDCard;
import com.sjj.mashibing.adapter.clazz.TFCard;
import com.sjj.mashibing.adapter.clazz.TFCardImpl;

/**
 * 实例适配器（Adapter）类-TF卡转SD卡类<br>
 */
public class SDAdapterTF implements SDCard {
    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        tfCard.writeTF(msg);
    }
}
