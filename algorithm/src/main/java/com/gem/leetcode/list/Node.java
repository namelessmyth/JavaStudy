package com.gem.leetcode.list;

/**
 * 链表节点<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/11/27
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int x) {
        val = x;
        next = null;
        random = null;
    }

    public Node(int[] array) {
        if (array != null && array.length > 0) {
            Node current = this;
            for (int i = 0; i < array.length; i++) {
                if (i == 0) {
                    val = array[0];
                } else {
                    Node temp = new Node(array[i]);
                    current.next = temp;
                    current = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ListNode{val=[");
        sb.append(this.val);
        int size = 1;
        Node next = this.next;
        while (next != null) {
            sb.append(",");
            sb.append(next.val);
            next = next.next;
            size++;
        }
        sb.append("], size={");
        sb.append(size);
        sb.append("}}");
        return sb.toString();
    }
}
