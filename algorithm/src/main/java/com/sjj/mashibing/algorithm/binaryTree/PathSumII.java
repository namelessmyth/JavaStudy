package com.sjj.mashibing.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目链接：https://leetcode.cn/problems/path-sum-II/<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/7
 */
public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        //满足要求的所有路径
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        //满足要求的其中一个路径
        ArrayList<Integer> path = new ArrayList<>();
        process(root, path, 0, sum, ans);
        return ans;
    }

    public static void process(TreeNode x, List<Integer> path, int preSum, int sum, List<List<Integer>> ans) {
        if (x.left == null && x.right == null) {
            //如果当前节点已经没有子节点，且节点值+累加值等于要求的值，说明这个路径就是要返回的。
            if (preSum + x.val == sum) {
                //在path里面将最后一个值加入
                path.add(x.val);
                //将当前这个有效路径加入到最终要返回的列表中去。
                ans.add(copy(path));
                //移除最后一个值，因为要返回上一个节点去继续计算其他可能性。
                path.remove(path.size() - 1);
            }
            return;
        }
        //走到这里说明当前节点还有子节点，需要判断是左还是右或者都有。
        // 将当前节点的值加到路径中去。
        path.add(x.val);
        preSum += x.val;
        if (x.left != null) {
            process(x.left, path, preSum, sum, ans);
        }
        if (x.right != null) {
            process(x.right, path, preSum, sum, ans);
        }
        path.remove(path.size() - 1);
    }

    public static List<Integer> copy(List<Integer> path) {
        List<Integer> ans = new ArrayList<>();
        for (Integer num : path) {
            ans.add(num);
        }
        return ans;
    }
}
