package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/valid-sudoku/">
 * 36. Valid Sudoku
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee36 {
    public boolean isValidSudoku(char[][] board) {
        //行统计
        int[][] rows = new int[9][9];
        //列统计
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    //计算当前数字的索引
                    int index = c - '1';
                    //在所在行中将这个值标记为已存在
                    rows[i][index]++;
                    //在所在列中将这个值标记为已存在
                    columns[j][index]++;
                    //在所在的子方格中将这个值标记为已存在
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        //如果这个值所在的行，所在的列，所在的子方格中，存在计数大于1说明重复。
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku0ms(char[][] board) {
        int[] cols = new int[9];//存储9列数字信息
        int[] littelBoard = new int[9];//存储小九宫格内数字信息
        int row;//存储当前遍历行的数字信息
        for (int i = 0; i < 9; i++) {
            row = 0;//行检测,每轮置0
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {//跳过空字符
                    continue;
                }
                int mask = 1 << (board[i][j] - '0');//使用9个比特位判定重复
                //对于num生成的mask只有第num位为1,其余为0,可以使用"与"运算,如果大于0,说明该位为1,即重复出现数字
                int k = (i / 3) * 3 + j / 3;//第k个小九宫格
                if ((row & mask) > 0 || (cols[j] & mask) > 0 || (littelBoard[k] & mask) > 0) {
                    return false;
                }

                row |= mask;
                cols[j] |= mask;
                littelBoard[k] |= mask;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] input = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new Lee36().isValidSudoku(input));
    }
}
