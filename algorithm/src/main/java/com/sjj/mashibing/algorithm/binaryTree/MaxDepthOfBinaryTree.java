package com.sjj.mashibing.algorithm.binaryTree;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/2
 */
public class MaxDepthOfBinaryTree {
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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            //如果当前节点为null则为0
            return 0;
        }
        //当前节点如果有子节点则继续递归判断，一直查到null为止，还要加上当前节点的1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
