package com.gem.leetcode;

import com.gem.leetcode.binaryTree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/invert-binary-tree/">
 * 226. 翻转二叉树（简单）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee226 {
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            TreeNode left = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(new Lee226().invertTree(root));
    }
}
