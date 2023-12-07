package com.gem.leetcode.list;

/**
 * 链表节点<br>
 *
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
            ListNode current = this;
            for (int i = 0; i < array.length; i++) {
                if (i == 0) {
                    val = array[0];
                } else {
                    ListNode temp = new ListNode(array[i]);
                    current.next = temp;
                    current = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ListNode{val:");
        sb.append(this.val);
        int size = 1;
        ListNode next = this.next;
        sb.append(", next:");
        if (next != null) {
            sb.append(next.val);
        }
        sb.append(", vals:[");
        sb.append(this.val);
        while (next != null) {
            sb.append(",");
            sb.append(next.val);
            next = next.next;
            size++;
        }
        sb.append("], size:");
        sb.append(size);
        sb.append("}");
        return sb.toString();
    }
}
