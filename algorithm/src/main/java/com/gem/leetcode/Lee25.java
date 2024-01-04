package com.gem.leetcode;

import com.gem.leetcode.list.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/">
 * 25. K 个一组翻转链表（困难）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/9/15
 */
public class Lee25 {
    /**
     * 将给定的单链表头节点，每隔K元素逆序重拍
     *
     * @param head 给定单链表的头节点
     * @param k    每隔K个元素逆序重排
     * @return 重排之后新的单链表的头元素
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        // 第一组凑齐了！
        head = end;
        reverse(start, end);
        // 上一组的结尾节点
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    /**
     * 根据给定的开始节点，返回单链表中往后数的第K个元素
     */
    public static ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            //如果K=5，第一次循环就是4，一直循环到K为0，也就是总共循环next了4次
            start = start.next;
        }
        return start;
    }

    /**
     * 将开始和结束节点之间的节点逆序重排。
     */
    public static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    /**
     * @return
     */
    public ListNode reverseKGroupMy(ListNode head, int k) {
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println(new Lee25().reverseKGroupMy(head, 4));
    }
}
