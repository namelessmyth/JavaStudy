package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/number-of-islands/">
 * 200. 岛屿数量（中等）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee200 {
    /**
     * <ol>
     *     <li>循环检测每一个格子，如果当前格子为1，则校验他周围的格子是否也为1</li>
     *     <li>对于已经检测过的格子，将其改成0，避免重复校验。这样检测一次就能一次性把连在一起的区域都检测过了。</li>
     *     <li>如果还有其他为1的格子，用同样的方法继续检测，符合要求就将结果+1</li>
     * </ol>
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            //循环每一个格子
            for (int j = 0; j < grid[0].length; j++) {
                //如果这个格子为1就开始判断
                if (grid[i][j] == '1') {
                    //递归检测和当前点连在一起的点，检测过的会改成'0'
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            //超出范围检测
            return;
        }
        if (grid[x][y] == '1') {
            //检测过的标记为0，避免重复检测
            grid[x][y] = '0';
            //递归周围的上下左右4个点
            dfs(grid, x - 1, y);
            dfs(grid, x + 1, y);
            dfs(grid, x, y - 1);
            dfs(grid, x, y + 1);
        }
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
        System.out.println(new Lee200().numIslands(input));
    }
}
