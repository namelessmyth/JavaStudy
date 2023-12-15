package com.gem.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/merge-intervals/">
 * 56. 合并区间（中等）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/14
 */
public class Lee56 {

    /**
     * <ol>
     *     <li>先按每一行数组的第0个元素升序排序</li>
     *     <li>创建一个和入参数组一样大小的临时数组作为返回值</li>
     *     <li>循环入参数组中的每一行，如果当前是第0个就直接放入到返回值数组中</li>
     *     <li>接下来判断入参数组中的这一行数组的开始是不是比返回值数组中这一行的末尾大，如果大就继续放</li>
     *     <li>如果不大，就将返回值数组中末尾元素改成和返回值数组中相比，较大的那个元素</li>
     *     <li>每次只要往返回值数组中放入元素时，下标就要+1，最后用这个下标来copy出来实际有值的行</li>
     * </ol>
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // 按照每行区间，第一个元素排序，避免出现[3,5][2,3][1,2][7,9]这种情况
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        //创建一个临时数组
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        // 遍历数组中每一行，每一行有2个元素
        for (int[] interval : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
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
        System.out.println(new Lee56().merge(input));
    }
}
