package com.gem.leetcode;

import com.gem.leetcode.binaryTree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/path-sum/">
 * 112. 路径总和
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            //如果当前已经是叶子节点，则判断值和目标值是否相等
            return targetSum == root.val;
        } else {
            //如果当前非叶子节点，减掉当前值，继续递归判断子节点
            int tmp = targetSum - root.val;
            return hasPathSum(root.left, tmp) || hasPathSum(root.right, tmp);
        }
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return process(root, 0, targetSum);
    }

    public boolean process(TreeNode x, int preSum, int targetSum) {
        boolean result = false;
        if (x.left == null && x.right == null) {
            //当前节点是叶子节点
            if (x.val + preSum == targetSum) {
                //如果累计值+当前节点的值=目标值
                return true;
            }
            return false;
        }
        // x是非叶节点
        preSum += x.val;

        if (x.left != null) {
            result = process(x.left, preSum, targetSum);
        }
        if (!result && x.right != null) {
            result = process(x.right, preSum, targetSum);
        }
        return result;
    }

    public boolean my(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return targetSum == root.val;
        } else {
            return my(root.left, targetSum - root.val) || my(root.right, targetSum - root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        System.out.println(new Lee112().hasPathSum(root, 23));
    }
}
