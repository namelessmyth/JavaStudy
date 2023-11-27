package com.gem.leetcode.list;

/**
 * 链表节点<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/11/27
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int[] array) {
        if (array != null && array.length > 0) {
            ListNode head = null;
            for (int a : array) {
                if (head == null) {
                    head = new ListNode(a);
                } else {
                    ListNode next = new ListNode(a);
                    head.next = next;
                    head = next;
                }
            }
        }
    }
}
