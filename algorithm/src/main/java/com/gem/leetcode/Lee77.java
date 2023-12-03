package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/set-matrix-zeroes/">
 * 73. 矩阵置零（中等）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee77 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //标记某一行是否有0
        boolean[] row = new boolean[m];
        //标记某一列是否有0
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    //如果该行该列有0
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4}
                , {5, 6, 7, 8}
                , {9, 10, 11, 12}};
        new Lee77().setZeroes(input);
    }
}
