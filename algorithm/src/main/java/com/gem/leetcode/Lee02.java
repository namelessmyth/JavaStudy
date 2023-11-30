package com.gem.leetcode;

import com.gem.leetcode.list.ListNode;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers/">
 * 2. 两数相加
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int up) {
        if (l1 == null && l2 == null) {
            //左右都为null
            if (up == 1) {
                l1 = new ListNode(up);
                return l1;
            }
            return null;
        } else if (l1 == null || l2 == null) {
            //左右有一个为null
            ListNode temp = (l1 == null) ? l2 : l1;
            //计算节点之和
            int sum = temp.val + up;
            //当前节点用个位
            temp.val = sum % 10;
            //如果是2位数则进1
            up = sum > 9 ? 1 : 0;
            temp.next = addTwoNumbers(temp.next, null, up);
            return temp;
        } else {
            //左右都不为null
            //计算节点之和
            int sum = l1.val + l2.val + up;
            //当前节点用个位
            l1.val = sum % 10;
            //如果是2位数则进1
            up = sum > 9 ? 1 : 0;
            l1.next = addTwoNumbers(l1.next, l2.next, up);
            return l1;
        }
    }

    public static void main(String[] args) {
        ListNode result = new Lee02().addTwoNumbers(new ListNode(new int[]{9, 9}), new ListNode(new int[]{9}));
        System.out.println(result);
    }
}
