package com.sjj.mashibing.algorithm.binaryTree;

/**
 * 比对两颗二叉树是否相等<br>
 * <a href="https://leetcode.cn/problems/same-tree/">leetcode链接</a>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/2
 */
public class CompareEquals {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result = false;
        if (p == null && q == null) {
            //都为空
            return true;
        } else if (p == null || q == null) {
            //有一个为空
            return false;
        } else {
            //都不为空，当前节点值相等，左节点递归相等，右节点递归相等。
            result = (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return result;
    }
}
