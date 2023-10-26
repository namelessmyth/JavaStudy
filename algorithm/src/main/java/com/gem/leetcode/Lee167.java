package com.gem.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150">
 * 167. 两数之和 II - 输入有序数组
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee167 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = numbers.length - 1; j > i; j--) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{++i, ++j};
                }
            }
        }
        return new int[]{0, 0};
    }

    /**
     * 充分利用数组是升序的这个规则。根据和在目标值的左边还是右边来缩小左右边界
     * @return
     */
    public int[] twoSum1ms(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            int k = numbers[left] + numbers[right];
            if (k == target) {
                //如果相等直接返回
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if (k > target) {
                //如果和在目标的右边，则缩小右边界。
                right--;
            } else {
                //如果和在目标的左边，则缩小左边界。
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Lee167().twoSum(new int[]{5, 25, 75}, 100)));
    }
}
