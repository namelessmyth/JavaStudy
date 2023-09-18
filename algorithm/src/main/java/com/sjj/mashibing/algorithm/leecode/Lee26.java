package com.sjj.mashibing.algorithm.leecode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/9/15
 */
public class Lee26 {
    /**
     * <ol>
     *     <li>定义2个指针，一个快一个慢。都从第二个开始</li>
     *     <li>快指针不停的往下循环。如果当前值和上一个值相等，则慢指针不动</li>
     *     <li>如果发现当前值和上一个不相等，则将慢指针当前位置的数改成快指针的值</li>
     *     <li>此时满指针向右移动一位。快指针继续右移。</li>
     * </ol>
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    /**
     * <ol>
     *     <li>从数组第2个元素开始循环</li>
     *     <li>只要发现当前元素和上一个元素相等，就把后面的元素整体向左移动。</li>
     *     <li>移动之后空出来的位置用Integer.MIN_VALUE填充</li>
     *     <li>从当前位置继续循环，如果当前值等于Integer.MIN_VALUE时，循环终止。</li>
     * </ol>
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE) {
                break;
            }
            if (nums[i] == nums[i - 1]) {
                move(nums, i--);
            } else {
                k++;
            }
        }
        return k;
    }

    public void move(int[] nums, int index) {
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = new Lee26().removeDuplicates2(nums1);
        System.out.println(Arrays.toString(nums1));
        System.out.println(k);
    }
}
