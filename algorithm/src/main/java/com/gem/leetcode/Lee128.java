package com.gem.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence/">
 * 128. 最长连续序列（中等）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee128 {
    /**
     * <ol>
     *     <li>12ms，击败95.58%使用Java的用户。首先对数组进行升序排序</li>
     *     <li>从1开始循环数组，如果当前数比前一个数大1则统计值+1。</li>
     *     <li>如果当前数和前一个数相等则什么也不干。因为{0, 1, 1, 2}这种要求返回3</li>
     *     <li>其他情况把统计值重置为1。返回历史最大统计数</li>
     * </ol>
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            //数组长度在1以下直接返回
            return nums.length;
        }
        //升序排序
        Arrays.sort(nums);
        int result = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                result = Math.max(++count, result);
            } else if (nums[i] == nums[i - 1]) {
                //如果相等不累加也不重置，因为{0, 1, 1, 2}这种要求返回3
                continue;
            } else {
                count = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Lee128().longestConsecutive(new int[]{1, 2, 0, 1}));
    }
}
