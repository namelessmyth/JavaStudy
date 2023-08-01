package com.sjj.mashibing.FactoryMethod;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/20
 */
public class Client {
    public static void main(String[] args) {
        IProductFactory af = new ProductFactoryA();
        IProduct a = af.getProduct();
        a.functionA();

        IProductFactory bf = new ProductFactoryA();
        IProduct b = bf.getProduct();
        b.functionA();
    }
}
