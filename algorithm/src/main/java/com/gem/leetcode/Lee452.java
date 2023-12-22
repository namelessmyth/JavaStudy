package com.gem.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum/">
 * 1. 两数之和
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee452 {
    /**
     * <ol>
     *     <li>首先按每个区间的右边界升序排序。（使用快速排序可以优化性能）</li>
     *     <li>遍历每一个区间，将上一个区间的右边界作为判断条件,如果下一个区间和上一个区间有重叠部分，则1根箭就能能射穿</li>
     *     <li>如果下一个区间和上一个区间没有重叠，则需要多加1根箭，同时将当前这个区间的右边界作为判断条件，继续遍历</li>
     * </ol>
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        //排完序,[2, 8],[7, 12],[10, 16]
        quickSort(points);
        //这里拿到8
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            //如果当前区间的左边界大于上一个的右边界，则一根箭就不够了。这里[7, 12]就有重叠
            if (balloon[0] > pos) {
                //用新的右边界更新判断条件
                pos = balloon[1];
                //将箭数加1
                ++ans;
            }
            //如果小于等于代表，这个区间和上一个区间是重合的，一根箭就行。[10, 16]就和上一个区间不重叠。
        }
        return ans;
    }

    public void quickSort(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                //按右边界升序排序
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void quickSort(int[][] points, int left, int right) {
        if (left < right) {
            int l = left - 1, r = right + 1, base = points[left + right >> 1][1];
            while (l < r) {
                while (points[++l][1] < base) ;
                while (points[--r][1] > base) ;
                if (l < r) {
                    int[] temp = points[l];
                    points[l] = points[r];
                    points[r] = temp;
                }
            }
            quickSort(points, left, r);
            quickSort(points, r + 1, right);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Lee452().findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {7, 12}}));
    }
}
