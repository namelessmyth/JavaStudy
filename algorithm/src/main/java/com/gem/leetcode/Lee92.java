package com.gem.leetcode;

import com.gem.leetcode.list.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list-ii/">
 * 92. 反转链表 II（中等）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode last = null;
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode leftLeft = null;
        ListNode rightRight = null;
        int reverse = 0;
        while (head != null) {
            if (head.val == left) {
                leftNode = head;
                leftLeft = last;
                head.next = rightRight;
                reverse++;
            } else if (head.val == right) {
                reverse = 0;
                rightNode = head;
                leftLeft = rightNode;
            }
            //记录下一个节点
            ListNode next = head.next;
            if (reverse > 0) {
                //将当前节点的下一个指向上一个，相当于取反。
                head.next = last;
                reverse++;
            }
            //将当前节点指变为上一个
            last = head;
            //将下一个变成当前节点，继续循环处理
            head = next;

        }
        if (leftLeft != null) {
            leftLeft.next = rightNode;
        }
        if (rightRight != null) {
            leftNode.next = rightRight;
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(new Lee92().reverseBetween(new ListNode(new int[]{1, 2, 3, 4, 5}), 2, 4));
    }
}
