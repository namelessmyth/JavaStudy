package com.gem.leetcode;

import com.gem.leetcode.list.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list-ii/">
 * 206. 反转链表
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee206 {
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        while (head != null) {
            //记录下一个节点
            ListNode next = head.next;
            //将当前节点的下一个指向上一个，相当于取反。
            head.next = last;
            //将当前节点指变为上一个
            last = head;
            //将下一个变成当前节点，继续循环处理
            head = next;
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(new Lee206().reverseList(new ListNode(new int[]{1, 2, 3, 4})));
    }
}
