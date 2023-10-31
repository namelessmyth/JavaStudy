package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150">
 * 209. 长度最小的子数组
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee209 {
    /**
     * 滑动窗口:右边界主动滑动，左边界被动移动的方法
     * 时间复杂度:O(N) 空间复杂度:O(1)
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        //滑动窗口的大小
        int result = Integer.MAX_VALUE;     //记录答案
        int sum = 0;        //滑动窗口的数值之和
        int i = 0;      //滑动窗口的起始位置
        int length = 0;     //滑动窗口的长度
        for (int j = 0; j < nums.length; j++) {
            //首先用单个数累加和，如果单个数累加起来都不大于target那就是没答案。
            sum += nums[j];
            while (sum >= target) {
                //窗口之和如果大于目标，代表当前已经能达标，寻找有没有更小的答案
                //获取当前子数组的长度
                length = j - i + 1;
                //比较当前的长度更小则更新。
                result = result < length ? result : length;
                //缩小左边界
                sum -= nums[i++];
            }
            //走到这里则继续右移右边界。
        }
        //如果result一直没更新过，就代表所有元素加起来都不符合要求。
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        System.out.println(new Lee209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
