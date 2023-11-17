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
public class Lee101 {
    public boolean isSymmetric(TreeNode root) {
        if (root != null) {
            return isSymmetric(root.left, root.right);
        }
        return false;
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)) {
            //如果当前2个节点的值相等，且左子节点和另一个的右子节点相等，右子节点和另一个的做子节点相等。
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(new Lee101().isSymmetric(root));
    }
}
