package com.sjj.mashibing.algorithm.random;

import java.util.Arrays;

/**
 * 从1-5随机到1-7随机<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/1/24
 */
public class Randon15To17 {
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
        return f7_02() + 1;
    }

    /**
     * 将f5函数调整成等概率返回0和1
     */
    public static int f7_01() {
        int res = 0;
        do {
            res = f5();
            //等于3重做
        } while (res == 3);
        //1,2改成0，3，5改成1
        return res < 3 ? 0 : 1;
    }

    public static int f7_02() {
        int res = 0;
        do {
            //一共3位，每一位都是等概率，所以加起来就是等概率返回[0-7]
            res = (f7_01() << 2) + (f7_01() << 1) + (f7_01() << 0);
            //遇到0就重新计算
        } while (res == 7);
        return res;
    }

    public static int f7Math() {
        return (int) (Math.random() * 7) + 1;
    }

    public static void main(String[] args) {
        int total = 100000;
        //使用数组位数来统计1-5中每个数的生成概率
        int[] count5 = {0, 0, 0, 0, 0};
        int[] count7 = {0, 0, 0, 0, 0, 0, 0};
        int[] count7m = {0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < total; i++) {
            count5[f5() - 1]++;
            count7[f7() - 1]++;
            count7m[f7Math() - 1]++;
        }
        System.out.println(total + "的总次数中，1-5每个数的生成次数：" + Arrays.toString(count5));
        System.out.println(total + "的总次数中，1-7每个数的生成次数：" + Arrays.toString(count7));
        System.out.println(total + "的总次数中，1-7每个数的生成次数：" + Arrays.toString(count7m));
    }
}
