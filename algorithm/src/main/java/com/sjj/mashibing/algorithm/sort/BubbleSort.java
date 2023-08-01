package com.sjj.mashibing.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序<br>
 * 假设给定一个数组，长度为N，数组下标范围为0~N-1。首先从0~N-1的范围内，依次把每个相邻位置更大的数往后交换位置。
 * 例如：给定数组[6, 3, 1, 2, 9, 4]，首先比对0和1位置的6和3，6比3大，则交换位置，
 * 再比对第2和3位置上的6和1，6比1大，则继续交换位置。
 * 以此类推，最大的数会被排到数组的最右面位置（N-1）。可以理解为最大值冒泡出来了。
 * 然后再从0~N-2的范围内再重复上述步骤，接下来N-2位置上就会是第2大的值。
 * 然后再是0~N-3，0~N-4，然后整个数组就从小到大排好序了。
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/1/12
 */
public class BubbleSort {
    public static int[] sort(int[] input) {
        if (input == null || input.length == 0) {
            return input;
        }
        int n = input.length;
        //第一层循环是数组的结束位置不断缩小，开始位置不变。
        for (int end = n - 1; end > 0; end--) {
            //第二层循环从第2个位置开始，不断的比较当前位置是否比前一个位置小，小则交换位置。
            for (int j = 1; j <= end; j++) {
                if (input[j] < input[j - 1]) {
                    swap(input, j - 1, j);
                }
            }
        }
        return input;
    }

    public static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        int[] a1 = {4, 11, 65, 3, 215, 67, 231, 45, 1};
        System.out.println(Arrays.toString(sort(a1)));
    }
}
