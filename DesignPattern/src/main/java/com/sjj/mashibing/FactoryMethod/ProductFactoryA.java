package com.sjj.mashibing.FactoryMethod;

/**
 * 工厂方法模式-具体工厂<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/20
 */
public class ProductFactoryA implements IProductFactory {
    public IProduct getProduct() {
        return new ProductA();
    }
}