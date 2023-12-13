package com.gem.leetcode;

import com.gem.leetcode.binaryTree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/minimum-absolute-difference-in-bst/">
 * 530. 二叉搜索树的最小绝对差
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee530 {
    //前一个处理过的节点
    TreeNode pre = null;
    //最小差，返回值
    int min = Integer.MAX_VALUE;

    /**
     * 题目已经说了，入参是一个二叉搜索树，所以左节点一定比根小，右节点一定比根大。
     * 所以只需要比较根节点和左节点，以及根节点和右节点。不需要比较左右节点。左右节点的差值不可能前面2种情况小
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return 0;
        }
        //先处理左节点
        getMinimumDifference(root.left);
        if(pre != null){
            //依次比较左根和根右之间的大小，取最小值
            min = Math.min(root.val - pre.val, min);
        }
        //计算完差值之后，将当前节点变成上节点
        pre = root;
        //再处理右节点。
        getMinimumDifference(root.right);
        return min;
    }

    public int my(TreeNode root) {
        if(root == null){
            return 0;
        }
        my(root.left);
        if(pre != null){
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        my(root.right);
        return min;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        System.out.println(new Lee530().getMinimumDifference(root));
    }
}
