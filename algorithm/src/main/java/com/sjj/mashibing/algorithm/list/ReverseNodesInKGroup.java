package com.sjj.mashibing.algorithm.list;

/**
 * K个节点的组内逆序调整<br>
 * 给定一个链表和他的头，将每K个元素的链表元素反转。然后返回新的链表。要求设计一个只用 `O(1)` 额外内存空间的算法解决此问题<br>
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/">leetcode题目链接</a><br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/2/10
 */
public class ReverseNodesInKGroup {

    /**
     * 此类为单链表的节点，是题目的前置条件，不用提交。
     */
    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return this.val + "";
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
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
    public ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            //如果K=5，第一次循环就是4，一直循环到K为0，也就是总共循环next了4次
            start = start.next;
        }
        return start;
    }

    /**
     * 将开始和结束节点之间的节点逆序重排。
     */
    public void reverse(ListNode start, ListNode end) {
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

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        ListNode head = node1;
        new ReverseNodesInKGroup().reverseKGroup(head, 3);
    }
}
