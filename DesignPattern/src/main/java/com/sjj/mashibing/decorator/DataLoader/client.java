package com.sjj.mashibing.decorator.DataLoader;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/30/0030
 */
public class client {
    public static void main(String[] args) {
        String info = "name:tom,age:15";
        DataLoaderDecorator decorator = new EncryptionDataDecorator(new BaseFileDataLoader("demo123.txt"));
        decorator.write(info);

        String data = decorator.read();
        System.out.println(data);
    }
}
