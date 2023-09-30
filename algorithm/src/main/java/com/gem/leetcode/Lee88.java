package com.gem.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/9/15
 */
public class Lee88 {
    /**
     * <ol>
     *     <li>新建一个List，将nums1和nums先后追加进去</li>
     *     <li>然后再给list排序</li>
     * </ol>
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        new Lee88().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
