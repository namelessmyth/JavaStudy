package com.gem.leetcode.binaryTree;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/3
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        String left = this.left == null ? "" : this.left.val + "";
        String right = this.right == null ? "" : this.right.val + "";
        return String.format("TreeNode{val:%s, left:%s, right:%s}", this.val, left, right);
    }
}
