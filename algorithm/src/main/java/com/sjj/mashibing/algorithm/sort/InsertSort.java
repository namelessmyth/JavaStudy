package com.sjj.mashibing.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/1/14
 */
public class InsertSort {
    private static int[] s1(int[] input) {
        if (input == null || input.length == 0) {
            return input;
        }
        int n = input.length;
        //0~0, 0~1, 0~2 ... 0~N-1,变量是end
        for (int end = 1; end < n; end++) {
            //不断的扩大排序范围，然后从新元素也就是当前范围最后一个元素开发，不断的和前一个元素比较，如果比前面的小就交换位置
            int index = end;
            while (index >= 1 && input[index] < input[index - 1]) {
                //如果当前位置的值比前一个的值小就交换位置，否则也不用继续循环了，因为前面的范围是排好序的。
                swap(input, index - 1, index);
                index--;
            }
        }
        return input;
    }

    private static int[] s2(int[] input) {
        if (input == null || input.length == 0) {
            return input;
        }
        int n = input.length;
        //0~0, 0~1, 0~2 ... 0~N-1,变量是end
        for (int end = 1; end < n; end++) {
            //不断的扩大排序范围，然后将新元素不断的和前一个元素比较，如果比前面的小就交换位置
            for (int j = end; j >= 1 && input[j] < input[j - 1]; j--) {
                swap(input, j - 1, j);
            }
        }
        return input;
    }

    private static int[] s3(int[] input) {
        if (input == null || input.length == 0) {
            return input;
        }
        int n = input.length;
        for (int end = 1; end < n; end++) {
            //以当前位置和下一个位置的视角重新循环
            for (int pre = end - 1; pre >= 0 && input[pre] > input[pre + 1]; pre--) {
                swap(input, pre, pre + 1);
            }
        }
        return input;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        int[] a1 = {11, 4, 65, 3, 215, 67, 3, 45, 1};
        System.out.println(Arrays.toString(s1(a1)));
        System.out.println(Arrays.toString(s2(a1)));
        System.out.println(Arrays.toString(s3(a1)));
    }
}
