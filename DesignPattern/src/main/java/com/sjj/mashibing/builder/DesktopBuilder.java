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
public class DesktopBuilder extends Builder {
    @Override
    public void buildCpu() {
        computer.setCpu("台式机Cpu");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("台式机内存");
    }

    @Override
    public void buildHd() {
        computer.setHd("台式机HD");
    }

    @Override
    public Computer getProduct() {
        return computer;
    }
}
