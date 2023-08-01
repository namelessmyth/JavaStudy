package com.sjj.mashibing.flyweight.jdk;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/4/3/0003
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        Integer i3 = Integer.valueOf(127);
        Integer i4 = 127;
        System.out.println(i1==i2);
        System.out.println(i3==i4);
    }
}
