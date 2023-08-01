package com.sjj.mashibing.algorithm.binaryTree;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/6
 */
public class BalancedBinaryTree {
    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int height){
            this.height = height;
            this.isBalanced = i;
        }
    }

    public Info process(TreeNode cur) {
        if (cur == null) {
            return new Info(true, 0);
        }
        Info left = process(cur.left);
        Info right = process(cur.right);
        int height = Math.max(left.height, right.height) + 1;
        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) < 2;
        return new Info(isBalanced, height);
    }

    public boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }
}
