package com.sjj.mashibing.algorithm.leecode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/9/15
 */
public class Lee27 {
    /**
     * 从给定的数组中移除值等于val的元素，把剩余的元素移动到数组首部。
     * <ol>
     *     <li>新建一个和nums一样大的空数组</li>
     *     <li>把不等于val的元素放到新数组中</li>
     * </ol>
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 2, 4, 3, 5, 6, 9, 3};
        int k = new Lee27().removeElement(nums1, 3);
        System.out.println(Arrays.toString(nums1));
        System.out.println(k);
    }
}
