package com.sjj.mashibing.algorithm.search;

import com.sjj.mashibing.algorithm.sort.BubbleSort;

import java.util.Arrays;

/**
 * 二分法查询<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/1/31
 */
public class Dichotomy {
    public static int find(int[] input, int num) {
        int index = -1;
        if (input == null || input.length == 0) {
            return index;
        }
        //左边界
        int L = 0;
        //右边界
        int R = input.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (input[mid] == num) {
                return mid;
            } else if (input[mid] < num) {
                //如果要找的数比中间位置的数大，则缩小左边界
                L = mid + 1;
            } else {
                //如果要找的数比中间位置的数小，则缩小右边界
                R = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 2, 5, 7, 8, 9, 21, 3};
        System.out.println(Arrays.toString(BubbleSort.sort(input)));
        System.out.println(find(input, 3));
        System.out.println(find(input, 4));
    }
}
