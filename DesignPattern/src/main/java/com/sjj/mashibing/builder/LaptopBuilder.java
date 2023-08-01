package com.sjj.mashibing.builder;

import lombok.Data;

/**
 * 笔记本建造器<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/22
 */
@Data
public class LaptopBuilder extends Builder {
    @Override
    public void buildCpu() {
        computer.setCpu("笔记本Cpu");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("笔记本内存");
    }

    @Override
    public void buildHd() {
        computer.setHd("笔记本HD");
    }

    @Override
    public Computer getProduct() {
        return computer;
    }
}
