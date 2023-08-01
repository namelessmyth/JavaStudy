package com.sjj.mashibing.algorithm.binaryTree;

/**
 * 路径求和<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/7
 */
public class PathSum {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return process(root, sum);
    }

    public static boolean process(TreeNode cur, int rest) {
        if (cur.left == null && cur.right == null) {
            //如果左右节点都为空则只需要判断当前节点的值和入参是否相等。
            return cur.val == rest;
        }
        boolean ans = false;
        if (cur.left != null) {
            //如果左节点不为空，将要求的值减掉当前节点的值传给左节点继续递归。
            ans = process(cur.left, rest - cur.val);
        }
        boolean ansRight = false;
        if (cur.right != null) {
            //如果左节点不为空，就继续计算右节点。
            ansRight = process(cur.right, rest - cur.val);
        }
        //左右只要任一节点满足要求就是true
        ans |= ansRight;
        return ans;
    }

    public static boolean isSum = false;
    public static boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        isSum = false;
        process(root, 0, sum);
        return isSum;
    }

    public static void process(TreeNode x, int preSum, int sum) {
        if (x.left == null && x.right == null) {
            if (x.val + preSum == sum) {
                isSum = true;
            }
            return;
        }
        // x是非叶节点
        preSum += x.val;
        if (x.left != null) {
            process(x.left, preSum, sum);
        }
        if (x.right != null) {
            process(x.right, preSum, sum);
        }
    }
}
