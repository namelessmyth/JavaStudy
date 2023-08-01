package com.sjj.mashibing.adapter.clazz;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/30/0030
 */
public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        SDCard sdCard = new SDCardImpl();
        System.out.println(computer.read(sdCard));

        System.out.println("========================");
        SDAdapterTF adapterTF = new SDAdapterTF();
        System.out.println(computer.read(adapterTF));
    }
}
