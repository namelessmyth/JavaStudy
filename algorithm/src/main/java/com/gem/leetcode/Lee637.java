package com.gem.leetcode;

import com.gem.leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/average-of-levels-in-binary-tree/">
 * 637. 二叉树的层平均值
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee637 {

    public List<Double> averageOfLevels(TreeNode root) {
        return new java.util.AbstractList<Double>() {
            List<Double> doubleList = new ArrayList<Double>();
            boolean init = false;
            public void init() {
                List<TreeNode> nodeList = new ArrayList<TreeNode>(Arrays.asList(root));
                while (nodeList.size() > 0) {
                    double count = 0.0;
                    List<TreeNode> nodeList2 = new ArrayList<TreeNode>();
                    for (TreeNode node : nodeList) {
                        count += node.val;
                        if (node.left != null) {
                            nodeList2.add(node.left);
                        }
                        if (node.right != null) {
                            nodeList2.add(node.right);
                        }
                    }
                    doubleList.add(count / nodeList.size());
                    nodeList = nodeList2;
                }
                init = true;
            }

            @Override
            public int size() {
                if (!init) {
                    init();
                }
                return doubleList.size();
            }

            @Override
            public Double get(int index) {
                if (!init) {
                    init();
                }
                return doubleList.get(index);
            }
        };
    }

    public List<Double> my2ms(TreeNode root) {
        List<Double> doubleList = new ArrayList<Double>();
        //父节点列表
        List<TreeNode> parentList = new ArrayList<TreeNode>(Arrays.asList(root));
        while (parentList.size() > 0) {
            double sum = 0.0;
            //子节点列表
            List<TreeNode> childNodes = new ArrayList<TreeNode>();
            for (TreeNode node : parentList) {
                sum += node.val;
                //读出左右子节点加入列表中
                if (node.left != null) {
                    childNodes.add(node.left);
                }
                if (node.right != null) {
                    childNodes.add(node.right);
                }
            }
            //算出当前父节点的平均值
            doubleList.add(sum / parentList.size());
            //将子节点变成父节点，继续循环
            parentList = childNodes;
        }
        return doubleList;
    }

    public static void main(String[] args) {
        System.out.println(new Lee637().averageOfLevels(new TreeNode(23)));
    }
}
