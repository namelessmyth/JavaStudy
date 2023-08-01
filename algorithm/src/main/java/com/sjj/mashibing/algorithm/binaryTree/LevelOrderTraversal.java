package com.sjj.mashibing.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 按层遍历收集节点<br>
 * 题目链接：https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/6
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root != null) {
            result = new LinkedList<>();
            //使用先进先出队列来存储当前要处理的节点。
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.add(root);
            while (!q.isEmpty()) {
                int size = q.size();
                //存放一层中的所有值。
                List<Integer> valList = new LinkedList<>();
                //队列中有多少值就执行多少遍
                for (int i = 0; i < size; i++) {
                    //弹出当前值，加入它的左右节点。
                    TreeNode node = q.poll();
                    valList.add(node.val);
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
                result.add(0, valList);
            }
        }
        return result;
    }
}
