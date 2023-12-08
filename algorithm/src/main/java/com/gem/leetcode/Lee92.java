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
    /**
     * https://leetcode.cn/problems/reverse-linked-list-ii/
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = new ListNode(0);   // 伪头节点
        pre.next = head;

        ListNode reversePre = pre;  // 反转区间的头节点的上一个节点，初始为pre
        int count = 1;  // 节点编号
        // 找到反转区间的头节点的上一个节点
        while (count < left) {
            reversePre = reversePre.next;
            count++;
        }

        ListNode reverseHead = reversePre.next; // 获取反转区间的头节点
        // 反转区间[left, right]的节点
        ListNode last = null;
        ListNode cur = reverseHead;
        ListNode next;
        while (count <= right) {
            next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
            count++;
        }
        // 重新拼接反转后的节点
        reversePre.next = last; // 反转区间前一个节点应该连接到反转区间的最后一个节点，即当前的last
        reverseHead.next = cur; // 反转区间的头节点应该连接到反转区间的下一个节点，即当前的next
        return pre.next;
    }


    /**
     * <ol>
     *     <li>给链表加一个空的头结点，确保程序逻辑一致</li>
     *     <li>通过循环找到left起始节点和left左边节点</li>
     *     <li>循环处理直到right节点，将其中的每个节点的next引用反过来</li>
     *     <li>将left左边节点指向right节点，left节点指向riht的右节点</li>
     * </ol>
     */
    public ListNode my(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode cur = newHead;
        for (int i = 1; i < left; i++) {
            cur = cur.next;
        }

        ListNode last = null;
        ListNode reverseLeft = cur;
        ListNode leftNode = cur.next;
        cur = cur.next;

        for (int i = left; i <= right; i++) {
            ListNode next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }

        reverseLeft.next = last;
        leftNode.next = cur;
        return newHead.next;
    }

    public static void main(String[] args) {
        System.out.println(new Lee92().my(new ListNode(new int[]{1, 2, 3, 4, 5}), 1, 5));
    }
}
