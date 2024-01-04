package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/">
 * 26. 删除有序数组中的重复项
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/9/15
 */
public class Lee26 {
    /**
     * <ol>
     *     <li>定义2个指针，一个x一个u。x正常遍历数组</li>
     *     <li>第1，2个走完，u的下标比x大1，从第3个开始。如果当前值和u左侧前面第2个值不等，则将u右移</li>
     *     <li>如果当前值和左侧前面第2个值相等，则u不动。直到快指针找到不相等的之后替换</li>
     * </ol>
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int k = 2;
        int u = 0;
        for (int x = 0; x < nums.length; x++) {
            if (u < k || nums[u - k] != nums[x]) {
                //前面2个保留，无论是否相同，从第三个开始
                nums[u++] = nums[x];
            }
        }
        return u;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5};
        System.out.println(new Lee26().removeDuplicates(nums1));
    }
}
