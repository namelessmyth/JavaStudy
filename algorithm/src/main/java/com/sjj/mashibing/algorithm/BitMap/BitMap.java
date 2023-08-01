package com.sjj.mashibing.algorithm.BitMap;

import java.util.HashSet;

/**
 * 位图功能实现<br>
 * 支持将某个数放入位图，从位图中移除，判断是否在位图中存在<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/2/17
 */
public class BitMap {
    public static class BitMap1 {
        //每一个long可以存放64以内的数，如果是10个long就是640.
        private long[] bits;

        public BitMap1(int max) {
            //将最大值是63以内就最少1个，如果是64就得2个，以此类推
            bits = new long[(max + 64) >> 6];//相当于除以64，2的6次方
        }

        public void add(int num) {
            // 先找到放入的数在数组中的哪个long里，num >> 6 即 num / 64；
            // 然后找到哪个long后再找是long的第几位，num % 64，即num & 63；
            // 然后将long对应位置上的数改成1，其他位置不变，即bits[num >> 6] = bits[num >> 6] | (1 << (num & 63))
            bits[num >> 6] |= (1L << (num & 63));
        }

        public void delete(int num) {
            // 同上，先找到是数组中哪个long，再找到是long中的哪一位，然后将这一位变成0。
            // num & 63是位数，让1左移相应位数后再取反再与上原来的就可以实现这一操作。
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("测试开始！");
        int max = 10000;
        BitMap1 bitMap = new BitMap1(max);
        HashSet<Integer> set = new HashSet<>();
        int testTime = 10000000;
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (max + 1));
            double decide = Math.random();
            if (decide < 0.333) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.666) {
                bitMap.delete(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("Oops!");
                    break;
                }
            }
        }
        for (int num = 0; num <= max; num++) {
            if (bitMap.contains(num) != set.contains(num)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }
}
