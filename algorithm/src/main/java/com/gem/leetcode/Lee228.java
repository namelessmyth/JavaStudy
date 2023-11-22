package com.gem.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/two-sum/">
 * 1. 两数之和
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        int first = nums[0];
        if (nums.length == 1) {
            list.add(first + "");
            return list;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                if (nums[i - 1] == first) {
                    list.add(first + "");
                } else {
                    list.add(first + "->" + nums[i - 1]);
                }
                first = nums[i];
            }
        }
        //处理最后一个元素
        if (nums[nums.length - 1] == nums[nums.length - 2] + 1) {
            //如果最后一个元素和前面元素是连续的
            list.add(first + "->" + nums[nums.length - 1]);
        } else {
            //如果不连续则只打印他自己。
            list.add(nums[nums.length - 1] + "");
        }
        return list;
    }

    public List<String> summaryRanges0ms(int[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer str = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                str.append("->");
                str.append(Integer.valueOf(nums[high]));
            }
            list.add(str.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MAX_VALUE - Integer.MIN_VALUE);
        System.out.println(new Lee228().summaryRanges(new int[]{-2147483648, -2147483647, 2147483647}));
    }
}
