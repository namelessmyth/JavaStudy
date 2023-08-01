package com.sjj.mashibing.strategy;

/**
 * 具体策略（Concrete Strategy）类<br>
 */
public class ConcreteStrategyB implements Strategy {

    @Override
    public void algorithm() {
        System.out.println("执行策略B");
    }
}
