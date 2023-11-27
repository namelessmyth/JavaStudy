package com.gem.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/rotate-image/">
 * 48. 旋转图像（中等）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee48 {
    public void rotate(int[][] matrix) {
        //二维数组的总行数
        int n = matrix.length;
        // 深拷贝 matrix -> tmp
        int[][] tmp = new int[n][];
        for (int i = 0; i < n; i++) {
            tmp[i] = matrix[i].clone();
        }
        // 根据元素旋转公式，遍历修改原矩阵 matrix 的各元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - 1 - i] = tmp[i][j];
            }
        }
    }

    public void rotateMy(int[][] matrix) {
        int n = matrix.length;
        int [][] tmp = new int[n][];
        for (int i = 0; i < n; i++) {
            tmp[i] = matrix[i].clone();
        }
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                matrix[j][n-1-i] = tmp[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = {{5, 1, 9, 11}
                , {2, 4, 8, 10}
                , {13, 3, 6, 7}, {13, 2, 6, 7}};
        new Lee48().rotateMy(input);
        System.out.println(Arrays.deepToString(input));
    }
}
