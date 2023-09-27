package com.sjj.mashibing.algorithm.leecode;

/**
 * <a href="https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150">55.跳跃游戏</a><br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/9/15
 */
public class Lee55 {
    /**
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        //记录可到达的最远位置
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                //如果i超过了这个最大位置，说明这个最大位置是数组内的位置。只有出现0才会进来。
                return false;
            }
            //更新最远的位置 = 当前位置 + 位置上的值
            max = Math.max(max, i + nums[i]);
        }
        //如果循环能完整结束，说明最远的位置是可达的，否则就在内部返回了
        return true;
    }

    public boolean transcribeOfficial(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; ++i) {
            //如果当前位置小于最大值
            if (i <= max) {
                //更新最远的位置 = 当前位置 + 位置上的值
                max = Math.max(max, i + nums[i]);
                if (max >= n - 1) {
                    //如果最大值已经超过数组长度了则代表可达，直接返回true。
                    return true;
                }
            }
        }
        //全部循环完说明，数组内没有任何一个数能达到。
        return false;
    }


    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 1, 1, 4};
        System.out.println(new Lee55().canJump(input));
    }
}
