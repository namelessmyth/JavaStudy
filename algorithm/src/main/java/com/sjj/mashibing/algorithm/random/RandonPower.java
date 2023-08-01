package com.sjj.mashibing.algorithm.random;

/**
 * 将0~x的概率调整为X的次方<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/1/16
 */
public class RandonPower {
    /**
     * 将随机数的出现概率调整为平方
     *
     * @return
     */
    public static double x2() {
        //由于是最大值，必须要求2个随机数结果都小于x，整体结果才能小于x。否则只有有一个数比x大。他就返回大的那个数。
        return Math.max(Math.random(), Math.random());
    }

    /**
     * 如果是min，概率会是什么？
     *
     * @return
     */
    public static double x2Min() {
        //取最小值时，只要有一个数小于x，他就会返回x。所以直接算不好算，我们可以先算2个数都小于X的概率，然后用1-就是最终结果。
        //一个数不在x的概率是(1-x)，2个就是(1-x)的平方。所以最终结果就是1-(1-x)的平方
        return Math.min(Math.random(), Math.random());
    }

    public static void main(String[] args) {
        int total = 1000000;
        int count = 0;
        int countMin = 0;
        double x = 0.3;
        for (int i = 0; i < total; i++) {
            if (x2() < x) {
                count++;
            }
            if (x2Min() < x) {
                countMin++;
            }
        }
        System.out.println(Math.pow(x, 2) + ",实际小于X的概率：" + ((double) count / (double) total));
        System.out.println(1 - Math.pow(1 - x, 2) + ",用最小函数小于X的概率：" + ((double) countMin / (double) total));
    }
}
