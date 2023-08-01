package com.sjj.mashibing.algorithm.binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/ <br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/3
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        int n = pre.length;
        // 将中序数组元素缓存起来，便于后序访问，不然就要遍历，用空间换时间。
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(in[i], i);
        }
        return myBuildTree(pre, 0, n - 1, in, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] pre, int pre_left, int pre_right, int[] in, int in_left, int in_right) {
        if (pre_left > pre_right) {
            return null;
        }
        // 先序遍历中的第一个节点就是头节点
        int pre_head = pre_left;
        // 根据先序数组中头结点的值找到在中序数组中头结点的位置
        int in_head = indexMap.get(pre[pre_head]);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(pre[pre_head]);
        // 得到左子树中的节点数目
        int size_left = in_head - in_left;
        // 递归地构造左子树
        root.left = myBuildTree(pre, pre_left + 1, pre_left + size_left, in, in_left, in_head - 1);
        // 递归地构造右子树，并连接到根节点
        root.right = myBuildTree(pre, pre_left + size_left + 1, pre_right, in, in_head + 1, in_right);
        return root;
    }
}
