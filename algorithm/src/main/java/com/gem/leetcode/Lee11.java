package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150">
 * 11. 盛最多水的容器
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee11 {
    public int maxArea(int[] height) {
        //双指针 i , j 分列水槽左右两端；
        int i = 0, j = height.length - 1;
        //水槽面积
        int res = 0;
        //循环直到i和j相遇
        while (i < j) {
            //比较2个板的高度，用短板计算面积，同时保留所有尝试中的最大值
            if (height[i] < height[j]) {
                res = Math.max(res, (j - i) * height[i++]);
            } else {
                res = Math.max(res, (j - i) * height[j--]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Lee11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
