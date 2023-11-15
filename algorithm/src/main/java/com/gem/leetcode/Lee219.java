package com.gem.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate-ii/">
 * 219. 存在重复元素 II
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean result = false;
        Map<Integer, Integer> map = new HashMap<>();
        int key;
        for (int i = 0; i < nums.length; i++) {
            key = nums[i];
            Integer index = map.get(key);
            if (index != null && i - index <= k) {
                return true;
            }
            map.put(key, i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Lee219().containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
    }
}
