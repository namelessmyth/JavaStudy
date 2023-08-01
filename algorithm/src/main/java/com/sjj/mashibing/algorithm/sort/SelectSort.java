package com.sjj.mashibing.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序<br>
 * 假设给定一个数组，长度为N，数组下标范围为0~N-1。首先从0~N-1的范围内找到最小值X，然后将他与0位置的数互换。
 * 然后再从1~N-1的范围找到最小值。将它与1位置的数互换，接着再在2~N-1的位置中找到最小值，将它与2位置的数互换，
 * 以此类推，整个数组就会从小到大排好序了。
 * @author namelessmyth
 * @version 1.0
 * @date 2023/1/12
 */
public class SelectSort {
    public static int[] s1(int[] input) {
        if (input == null || input.length == 0) {
            return input;
        }
        int n = input.length;
        for (int i = 0; i < n; i++) {
            //首先假设i位置就是最小值的位置
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                //在i位置之后，如果找到比i位置更小的数，则更新索引，循环完了就知道最小的索引在哪里了。
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }
            //交换最小值和i位置的值
            swap(input, i ,minIndex);
        }
        return input;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        int[] a1 = {4, 11, 65, 3, 215, 67, 231, 45, 1};
        System.out.println(Arrays.toString(s1(a1)));
    }
}
