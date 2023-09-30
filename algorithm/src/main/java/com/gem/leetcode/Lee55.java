package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150">
 *     55.跳跃游戏
 * </a><br>
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
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean selfWrite(int[] nums) {
        int max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > max) {
                //如果遍历超出了最大值，说明当前这个位置是不可达的。也就不可能达到末尾
                break;
            }
            max = Math.max(max, nums[i] + i);
            if (max >= n - 1) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 1, 1, 4};
        System.out.println(new Lee55().selfWrite(input));
    }
}
