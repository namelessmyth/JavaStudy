package com.gem.leetcode;

import com.gem.leetcode.binaryTree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/">
 * 108. 将有序数组转换为二叉搜索树
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee108 {
    /**
     * <ol>
     *     <li>递归方法：根据左右边界，计算数组的中间位置</li>
     *     <li>将中间位置的元素作为二叉树的头，左边范围的元素从左边界到中间元素-1的里面继续递归</li>
     *     <li>右边范围的元素从左边界+1到右边界之中继续递归</li>
     *     <li>直到递归到左右边界相等，也就是指向数组中的某一个元素时，层层返回</li>
     * </ol>
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        // 以升序数组的中间元素作为根节点 root。
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // 递归的构建 root 的左子树与右子树。
        root.left = dfs(nums, lo, mid - 1);
        root.right = dfs(nums, mid + 1, hi);
        return root;
    }

    private TreeNode my(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = my(nums, left, mid - 1);
        root.right = my(nums, mid + 1, right);
        return root;
    }


    public static void main(String[] args) {
        System.out.println(new Lee108().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }
}
