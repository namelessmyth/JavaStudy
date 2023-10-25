package com.gem.leetcode;

import com.gem.leetcode.binaryTree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/submissions/477152648/?envType=study-plan-v2&envId=top-interview-150">
 * 104. 二叉树的最大深度
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            //如果当前节点为null则为0
            return 0;
        }
        //当前节点如果有子节点则继续递归判断，一直查到null为止，还要加上当前节点的1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        System.out.println(new Lee104().maxDepth(root));
    }

    public int transcribe(TreeNode root) {
        int result = 0;
        if (root != null) {
            result = Math.max(transcribe(root.left), transcribe(root.right)) + 1;
        }
        return result;
    }
}
