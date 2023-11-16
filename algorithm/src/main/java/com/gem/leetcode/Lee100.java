package com.gem.leetcode;

import com.gem.leetcode.binaryTree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/same-tree/">
 * 100. 相同的树（简单）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        } else if (p == null && q == null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(1);
        System.out.println(new Lee100().isSameTree(left, right));
    }
}
