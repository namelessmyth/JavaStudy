package com.sjj.mashibing.algorithm.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/12
 */
public class PartitionAndQuickSort {
    /**
     * 2区域分区，小于等于和大于
     */
    public static void partition2(int[] arr) {
        if (arr != null) {
            int length = arr.length;
            int left = -1;
            int i = 0;
            while (i < length) {
                if (arr[i] <= arr[length - 1]) {
                    swap(arr, ++left, i++);
                } else {
                    i++;
                }
            }
        }
    }

    public static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    /**
     * 3区域分区，小于、等于、大于
     */
    public static void partition3(int[] arr) {
        if (arr != null) {
            int length = arr.length;
            int left = -1;
            int right = length - 1;
            int i = 0;
            while (i < right) {
                if (arr[i] < arr[length - 1]) {
                    swap(arr, ++left, i++);
                } else if (arr[i] > arr[length - 1]) {
                    swap(arr, --right, i);
                } else {
                    i++;
                }
            }
            swap(arr, length - 1, right);
        }
    }

    /**
     * 快速排序-递归实现
     */
    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        //首先对当前数组进行分区，分出小于，等于，大于，3个区
        int[] equalE = partition(arr, L, R);
        process(arr, L, equalE[0] - 1);//处理左区域，小于
        process(arr, equalE[1] + 1, R);//处理右区域，大于
    }

    /**
     * 从L到R指定范围分区。
     * 返回相等区域的左边界和右边界
     */
    public static int[] partition(int[] arr, int L, int R) {
        int left = L - 1;//左区域下标，从左边界前面1位开始
        int right = R;//右区域下标，从右边界最后1位开始
        int i = L;//循环遍历下标
        while (i < right) {
            if (arr[i] < arr[R]) {
                swap(arr, ++left, i++);
            } else if (arr[i] > arr[R]) {
                swap(arr, --right, i);
            } else {
                i++;
            }
        }
        //循环完了之后，交换右边界最左侧和最后一位数
        swap(arr, right, R);
        return new int[] { left + 1, right };
    }

    public static class Job {
        public int L;
        public int R;

        public Job(int left, int right) {
            L = left;
            R = right;
        }
    }


    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        Stack<Job> stack = new Stack<>();
        stack.push(new Job(0, arr.length - 1));
        while (!stack.isEmpty()) {
            Job cur = stack.pop();
            int[] equals = partition(arr, cur.L, cur.R);
            if (equals[0] > cur.L) { // 有< 区域
                stack.push(new Job(cur.L, equals[0] - 1));
            }
            if (equals[1] < cur.R) { // 有 > 区域
                stack.push(new Job(equals[1] + 1, cur.R));
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 5, 4, 5, 1, 3};
        partition2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
