package com.sjj.mashibing.builder;

/**
 * 客户端<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/22
 */
public class Client {
    public static void main(String[] args) {
        Director d = new Director(new DesktopBuilder());
        Computer c1 = d.construct();
        System.out.println(c1);

        d = new Director(new LaptopBuilder());
        c1 = d.construct();
        System.out.println(c1);
    }
}
