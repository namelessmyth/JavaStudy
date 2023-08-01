package com.sjj.mashibing.builder;

/**
 * 接口功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/22
 */
public abstract class Builder {
    protected Computer computer = new Computer();

    public abstract void buildCpu();

    public abstract void buildMemory();

    public abstract void buildHd();

    public abstract Computer getProduct();
}
