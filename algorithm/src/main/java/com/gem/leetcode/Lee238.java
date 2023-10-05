package com.gem.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-interview-150">
 * 238. 除自身以外数组的乘积
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee238 {
    /**
     * <ol>
     *     <li>创建一个数组answer，第0位为1，然后从入参数组nums左边开始累加乘积。</li>
     *     <li>answer[0]=1, answer[1]=nums[0]*answer[0], answer[2]=nums[1]*answer[1], 直至尾部</li>
     *     <li>然后定义一个临时变量r=1，从尾部开始循环answer[n-1]=answer[i]*R，并将nums中从尾部开始的值累加在R中的</li>
     *     <li>这样时间复杂度就是O(2n)，空间复杂度为O(1),输出数组不被视为额外空间</li>
     * </ol>
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示入参数组索引i左侧所有元素的乘积。
        // 索引为 '0' 的元素左侧没有元素，所以answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R为入参数组右侧所有元素的乘积，刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 4, 5, 2};
        int[] result = new Lee238().productExceptSelf(input);
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(result));
    }
}
