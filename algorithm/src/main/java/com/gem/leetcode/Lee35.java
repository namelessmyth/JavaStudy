package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/search-insert-position">
 * 35. 搜索插入位置
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee35 {
    /**
     * 二分查找<br>
     * 定义左右边界，然后找到左右边界的中间位置。<br>
     * 如果目标值等于中间位置的值，则直接返回当前数组索引，否则继续寻找。<br>
     * 如果目标值小于中间位置的值，则缩小右边节，继续向左找。<br>
     * 如果目标值大于中间位置的值，则增大左边节，继续向右找。<br>
     * @param nums 有序数组
     * @param target 目标值
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 找到区间的中间位置
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                // 如果找到直接返回
                return mid;
            } else if (nums[mid] < target) {
                // 如果目标值在中间位置右边，则左边界右移，继续向右找
                left = mid + 1;
            } else {
                // 如果目标值在中间位置左边，则右边界左移，继续向左找
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Lee35().searchInsert(new int []{1, 3, 5, 6}, 2));
    }
}
