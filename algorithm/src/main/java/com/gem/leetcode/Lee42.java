package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/trapping-rain-water/">
 * 42. 接雨水-困难
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee42 {
    /**
     * <ol>
     *     <a href="https://zhuanlan.zhihu.com/p/79811305">接雨水题解</a>
     *     <li>解法一：按列求</li>
     *     <li>求每一列的水，我们只需要关注当前列，以及左边最高的墙，右边最高的墙就够了</li>
     *     <li>装水的多少，当然根据木桶效应，我们只需要看左边最高的墙和右边最高的墙中较矮的一个就够了</li>
     *     <li>所以，根据较矮的那个墙和当前列的墙的高度可以分为三种情况。</li>
     * </ol>
     */
    public int trap1(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * <ol>
     *     <a href="https://zhuanlan.zhihu.com/p/79811305">接雨水题解</a>
     *     <li>解法二：动态规划</li>
     * </ol>
     */
    public int trap(int[] height) {
        int sum = 0;
        if(height.length < 3){
            return sum;
        }
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Lee42().trap(new int []{1}));
    }
}
