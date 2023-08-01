package com.sjj.mashibing.algorithm.random;

import java.util.Arrays;

/**
 * 从01不等概率到01等概率<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/1/24
 */
public class Randon01 {
    /**
     * 已知函数，回忆固定概率返回0和1之间的随机数。例如：84%
     */
    public static int x() {
        return Math.random() < 0.33 ? 0 : 1;
    }

    /**
     * 将x()函数转换成固定概率返回0和1
     */
    public static int y() {
        int res = 0;
        do {
            res = x();
        } while (res == x());
        //这里f函数至少执行2次。只有01，10会返回，11和00都不会返回。
        return res;
    }

    public static void main(String[] args) {
        int total = 100000;
        int[] count1 = {0, 0};
        int[] count2 = {0, 0};
        for (int i = 0; i < total; i++) {
            count1[x()]++;
            count2[y()]++;
        }
        System.out.println(total + "的总次数中，0，1每个数的生成次数：" + Arrays.toString(count1));
        System.out.println(total + "的总次数中，0，1每个数的生成次数：" + Arrays.toString(count2));
    }
}
