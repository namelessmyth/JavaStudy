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

    /**
     *
     * <ol>有效二叉搜索树定义如下
     *     <li>节点的左子树只包含小于当前节点的数（递归）。</li>
     *     <li>节点的右子树只包含大于当前节点的数（递归）。</li>
     *     <li>所有左子树和右子树自身必须也是二叉搜索树。</li>
     * </ol>
     * @param node
     * @param min
     * @param max
     * @return
     */
    public boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            //当前节点必须在最小值和最大值之间，不在这个范围则不是。
            return false;
        }
        //对于左子节点，应该要小于父节点且大于最小值，对于右子节点应该大于父节点小于最大值
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public boolean my(TreeNode node, long min, long max) {
        if(node != null){
            if(node.val <= min || node.val >= max){
                return false;
            }
            return my(node, min, node.val) && my(node, node.val, max);
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
