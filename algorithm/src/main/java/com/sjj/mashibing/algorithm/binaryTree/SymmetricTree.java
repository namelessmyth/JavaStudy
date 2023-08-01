package com.sjj.mashibing.algorithm.binaryTree;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/2
 */
public class SymmetricTree {
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

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        //解法2：将根节点的左右节点当成2棵树。
        return isMirror(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode root) {
        //直接从根节点开始将同一棵树当成2棵树。
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode p, TreeNode q) {
        boolean result = false;
        if (p == null && q == null) {
            //都为空
            return true;
        } else if (p == null || q == null) {
            //有一个为空
            return false;
        } else {
            //都不为空，当前节点值相等，左节点和右节点相等，右节点和左节点相等。
            result = (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);
        }
        return result;
    }
}
