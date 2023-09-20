package com.sjj.mashibing.algorithm.leecode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/9/15
 */
public class Lee169 {
    /**
     * <ol>
     *     <li>首先给数据升序排序</li>
     *     <li>然后从第二个开始，统计次数，如果当前这个数和上一个数相同则+1</li>
     *     <li>如果当前值和上一个数不同，则次数变成1，继续统计</li>
     *     <li>按照题目意思，数组中一定会有一个次数超过n/2的</li>
     * </ol>
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int k = 1;
        Arrays.sort(nums);
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result) {
                k++;
            } else {
                k = 1;
                result = nums[i];
            }
            if (k > nums.length / 2) {
                break;
            }
        }
        return result;
    }

    /**
     * 官方：摩尔投票法： 核心理念为 票数正负抵消 。此方法时间和空间复杂度分别为 O(N)O(N)O(N) 和 O(1)O(1)O(1) ，为本题的最佳解法。
     *
     * @param nums
     * @return
     */
    public int majorityElement0(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,2,1,1,1,2,2, 1,1};
        int result = new Lee169().majorityElement(nums1);
        System.out.println(Arrays.toString(nums1));
        System.out.println(result);
    }
}
