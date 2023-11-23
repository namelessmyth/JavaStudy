package com.gem.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/two-sum/">
 * 1. 两数之和
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        //矩形高度
        int m = matrix.length;
        //矩形宽度
        int n = matrix[0].length;
        //上下左右边界
        int up = 0, down = m - 1, left = 0, right = n - 1;
        //注意！！！break条件要在内部执行，每次循环一次都要判断一下是否越界，越界则直接退出
        while (true) {
            //1、左->右
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            if (++up > down) {
                //上边界下移，判断是否和下边界重合
                break;
            }
            //2、上->下
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if (left > --right) {
                //右边界左移，判断是否和左边界重合
                break;
            }
            //3、右->左
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            if (up > --down) {
                //下边界上移，判断是否和上边界重合
                break;
            }
            //4、下->上
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) {
                //左边界右移，判断是否和右边界重合
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4}
                , {5, 6, 7, 8}
                , {9, 10, 11, 12}};
        System.out.println(new Lee54().spiralOrder(input));
    }
}
