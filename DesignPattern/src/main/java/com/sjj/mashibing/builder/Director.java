package com.sjj.mashibing.builder;

/**
 * 指挥者<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/22
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Computer construct() {
        builder.buildCpu();
        builder.buildMemory();
        builder.buildHd();
        return builder.getProduct();
    }
}
