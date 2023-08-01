package com.sjj.mashibing.algorithm.Logarithm;

import com.sjj.mashibing.algorithm.sort.SelectSort;

/**
 * 对数器-排序<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/1/27
 */
public class SortLogar {
    /**
     * 按要求生成数组
     * @param maxLen 数组长度最大值
     * @param maxValue 数组元素最大值
     * @return
     */
    public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }

    /**
     * 数组复制方法
     */
    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    // 检查数组是否排序成功，arr1和arr2一定等长
    public static boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max > arr[i]) {
                return false;
            }
            max = Math.max(max, arr[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int maxLen = 5;
        int maxValue = 1000;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = lenRandomValueRandom(maxLen, maxValue);
            //排序之前备份原始数组
            int[] tmp = copyArray(arr1);
            //执行选择排序
            SelectSort.s1(arr1);
            if (!isSorted(arr1)) {
                //如果出现问题，将错误数据比对并打印出来
                for (int j = 0; j < tmp.length; j++) {
                    System.out.print(tmp[j] + " ");
                }
                System.out.println("选择排序错了！");
                break;
            }
        }
    }
}
