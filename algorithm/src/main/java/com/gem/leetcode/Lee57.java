package com.gem.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/insert-interval/">
 * 57. 插入区间（中等）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/14
 */
public class Lee57 {

    /**
     * <ol>
     *     <li>先按每一行数组的第0个元素升序排序</li>
     * </ol>
     *
     * @param intervals
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int idx = 0;
        // 首先小于等于新区间范围开始的区间加入到结果集中
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res[idx++] = intervals[i++];
        }
        // 接着判断当前区间是否与新区间重叠，重叠的话就进行合并，直到遍历到当前区间在新区间的右边且相离，
        // 将最终合并后的新区间加入结果集
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res[idx++] = newInterval;
        // 最后将新区间右边且相离的区间加入结果集
        while (i < intervals.length) {
            res[idx++] = intervals[i++];
        }

        return Arrays.copyOf(res, idx);
    }

    public int[][] my(int[][] intervals) {
        Arrays.sort(intervals, (pre, post) -> pre[0] - post[0]);
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] row : intervals) {
            if (idx == -1 || row[0] > res[idx][1]) {
                res[++idx] = row;
            } else {
                res[idx][1] = Math.max(res[idx][1], row[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }


    public static void main(String[] args) {
        int[][] input = {
                {1, 3}
                , {2, 6}
                , {8, 10}
                , {15, 18}};
        System.out.println(new Lee57().insert(input, new int[]{1, 10}));
    }
}
