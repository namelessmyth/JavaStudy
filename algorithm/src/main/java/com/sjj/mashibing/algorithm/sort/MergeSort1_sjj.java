package com.sjj.mashibing.algorithm.sort;

/**
 * 归并排序-递归实现<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/8
 */
public class MergeSort1_sjj {

    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * 对数组指定位置L到R，进行归并排序
     * @param arr 要排序的数组
     * @param L 数组左边界
     * @param R 数组右边界
     */
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] temp = new int[R - L + 1];
        int l1 = 0;
        int r1 = M + 1;
        int i = 0;
        while (l1 <= M && r1 <= R) {
            temp[i++] = (temp[l1] <= temp[r1] ? arr[l1++] : arr[r1++]);
        }
        while (l1 <= M) {
            temp[i++] = arr[l1++];
        }
        while (r1 <= R) {
            temp[i++] = arr[r1++];
        }
        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }


    // for test
    public static void main(String[] args) {

    }
}
