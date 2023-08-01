package com.sjj.mashibing.algorithm.random;

import java.util.Arrays;

/**
 * 从a-b随机到c-d随机<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/1/24
 */
public class RandonAb2Cd {
    /**
     * Math.random() 是[0-1)的随机，不包括1 <br>
     * (int) (Math.random() * 5)是0-4的随机，+1就是1-5的随机
     *
     * @return 1-5的随机整数
     */
    public static int f5() {
        return (int) (Math.random() * 5) + 1;
    }

    public static int f7() {
        int res = 0;
        do {
            //此处返回的是[0-7]的随机数
            res = (f7_01() << 2) + (f7_01() << 1) + (f7_01() << 0);
            //遇到0就重新计算
        } while (res == 0);
        return res;
    }

    /**
     * 将f5函数调整成随机返回0和1
     */
    public static int f7_01() {
        int res = 0;
        do {
            res = f5();
        } while (res == 3);
        return res < 3 ? 0 : 1;
    }

    public static int char2int(char c) {
        return c - '0';
    }

    public static char int2char(int i) {
        char c = (char) (i + '0');
        return c;
    }

    public static void main(String[] args) {
        System.out.println(char2int('a'));
        System.out.println(int2char(1));
    }
}
