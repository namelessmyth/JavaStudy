package com.gem.leetcode;

import com.gem.leetcode.binaryTree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/validate-binary-search-tree/">
 * 98. 验证二叉搜索树（中等）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    public boolean myfault(TreeNode root) {
        if (root != null) {
            if(root.left != null && root.left.val >= root.val){
                return false;
            }
            if(root.right != null && root.right.val <= root.val){
                return false;
            }
            if(!isValidBST(root.left) || !isValidBST(root.right)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        System.out.println(new Lee98().isValidBST(root));
    }
}
