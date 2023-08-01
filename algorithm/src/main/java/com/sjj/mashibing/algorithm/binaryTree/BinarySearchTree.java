package com.sjj.mashibing.algorithm.binaryTree;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/6
 */
public class BinarySearchTree {
    public static class Info {
        public boolean isBST;
        public int max;
        public int min;
        public Info(boolean is, int max, int min) {
            isBST = is;
            max = max;
            min = min;
        }
    }

    public boolean isValidBST(TreeNode root) {
        //return process(root).isBST;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            //校验当前节点的值是否比最小值小，比最大值大。
            return false;
        }
        // 校验左树的值是否小于头结点的值，校验右树的值是否大于头结点的值。
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public static Info process(TreeNode x) {
        Info result = null;
        if (x != null) {
            Info left = process(x.left);
            Info right = process(x.right);

            int min = x.val;
            int max = x.val;
            boolean leftIsBst = true;
            boolean rightIsBst = true;
            boolean leftMaxLessX = true;
            boolean rightMinMoreX = true;

            if (left != null) {
                min = Math.min(left.min, min);
                max = Math.max(left.max, max);
                leftIsBst = left.isBST;
                leftMaxLessX = left.max < x.val;
            }
            if (right != null) {
                min = Math.min(right.min, min);
                max = Math.max(right.max, max);
                rightIsBst = right.isBST;
                rightMinMoreX = right.min > x.val;
            }

            boolean isBST = false;
            if (leftIsBst && rightIsBst && leftMaxLessX && rightMinMoreX) {
                isBST = true;
            }
            result = new Info(isBST, max, min);
        }
        return result;
    }
}
