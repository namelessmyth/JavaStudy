package com.gem.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150<br>
 * 189. 轮转数组
 * @author namelessmyth
 * @version 1.0
 */
public class Lee189 {
    /**
     * <ol>
     *     <li>首先判断要移动的位数如果是数组的整数倍，则直接返回就行，因为即使移动结果就是原数组</li>
     *     <li>创建一个和入参数组一样长的空数组。循环源数据，将原数组的元素通过计算放到新数组对应的位置上</li>
     *     <li>对于源数组i位置的元素，应该放到新数组(i+k) mod length 的位置上</li>
     *     <li>将新数组覆盖老数组</li>
     * </ol>
     *
     * @param nums
     * @return
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k > 0) {
            int[] newArr = new int[n];
            for (int i = 0; i < n; ++i) {
                newArr[(i + k) % n] = nums[i];
            }
            System.arraycopy(newArr, 0, nums, 0, n);
        }
    }

    public void transcribeOfficial(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k > 0) {
            int[] temp = new int[nums.length];
            for (int i = 0; i < n; ++i) {
                int newIndex = (i + k) % n;
                temp[newIndex] = nums[i];
            }
            System.arraycopy(temp, 0, nums, 0, n);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Lee189().transcribeOfficial(nums1, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
