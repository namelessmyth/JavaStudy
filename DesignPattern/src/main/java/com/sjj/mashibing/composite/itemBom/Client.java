package com.sjj.mashibing.composite.itemBom;

import java.math.BigDecimal;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/4/3/0003
 */
public class Client {
    public static void main(String[] args) {
        Row root = new Bom("01.01", BigDecimal.ONE, BigDecimal.ZERO);

        Row b21 = new Bom("02.01", BigDecimal.ONE, BigDecimal.ZERO);
        root.addChild(b21);

        Row b31 = new Bom("03.01", BigDecimal.ONE, new BigDecimal("3.1"));
        b21.addChild(b31);

        Row b32 = new Bom("03.02", BigDecimal.ONE, new BigDecimal("3.2"));
        b21.addChild(b32);

        Row b22 = new Bom("02.02", BigDecimal.ONE, BigDecimal.ZERO);
        root.addChild(b22);

        Row b41 = new Bom("04.01", BigDecimal.ONE, new BigDecimal("4.2"));
        b22.addChild(b41);

        System.out.println(root.getPrice());
    }
}
