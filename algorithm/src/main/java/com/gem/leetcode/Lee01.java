package com.gem.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum/">
 * 1. 两数之和
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee01 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                result = new int[]{i, index};
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Lee01().twoSum(new int[]{1, 2, 3}, 3));
    }
}
