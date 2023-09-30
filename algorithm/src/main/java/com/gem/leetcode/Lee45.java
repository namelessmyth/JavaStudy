package com.gem.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150">45. 跳跃游戏 II</a><br><br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/9/15
 */
public class Lee45 {
    /**
     * <ol>
     *     <li>贪心算法，每次找局部最优，最后达到全局最优。这道题里，就是每一次跳，都要在能跳到的位置中找到跳的最远的位置。</li>
     *     <li>例如，对于数组 [2,3,1,2,4,2,3]，初始位置是下标 0，从下标 0 出发，最远可到达下标 2</li>
     *     <li>然后在可到达的位置中，位置1上的3可以跳的更远，所以跳到位置1的位置</li>
     *     <li>跳到位置1，能跳的范围中，4可以跳的更远，所以下次跳到 4的位置。</li>
     *     <li>到达4的位置时再跳一次就可以到达末尾了。总跳跃次数3</li>
     *     <li>题目保证可以到达 nums[n-1]，0 <= nums[i] <= 1000</li>
     * </ol>
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public int transcribeOfficial(int[] nums) {
        int step = 0;
        int max = 0;
        //一次能跳到最远的边界
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的位置
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                //如果不进来说明，上一次的最大位置已经大于等于数组长度了
                //如果进来说明，上一次跳的边界位置还在数组内，更新边界并将跳跃次数增加 1，继续跳
                end = max;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 3, 1, 2, 4, 2, 3};
        int result = new Lee45().jump(nums1);
        System.out.println(Arrays.toString(nums1));
        System.out.println(result);
    }
}
