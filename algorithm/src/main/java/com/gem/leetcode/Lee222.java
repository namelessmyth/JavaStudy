package com.gem.leetcode;

import com.gem.leetcode.binaryTree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/count-complete-tree-nodes/">
 * 222. 完全二叉树的节点个数
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee222 {
    public int countNodes(TreeNode root) {
        if(root != null){
            int result = 1;
            int left = countNodes(root.left);
            int right = countNodes(root.right);
            return result + left + right;
        }
        return 0;
    }

    public int countNodes(TreeNode node, int result) {
        if(node != null){
            result ++;
            result = countNodes(node.left,result);
            result = countNodes(node.right,result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Lee222().countNodes(new TreeNode(2)));
    }
}
