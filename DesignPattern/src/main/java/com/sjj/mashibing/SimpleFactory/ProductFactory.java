package com.sjj.mashibing.SimpleFactory;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/20
 */
public class ProductFactory {
    public static IProduct getProduct(String prodType) {
        if ("A".equals(prodType)) {
            return new ProductA();
        } else {
            return new ProductB();
        }
    }

    public static void main(String[] args) {
        IProduct a = ProductFactory.getProduct("A");
        a.functionA();

        IProduct b = ProductFactory.getProduct("B");
        b.functionA();
    }
}