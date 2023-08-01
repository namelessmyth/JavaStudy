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
public class ReverseNodesInKGroupSjj {

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
    }

    /**
     * 将给定的单链表头节点，每隔K元素逆序重拍
     *
     * @param head 给定单链表的头节点
     * @param k    每隔K个元素逆序重排
     * @return 重排之后新的单链表的头元素
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getGroupEnd(start, k);
        if (end != null) {
            head = end;
            reverse(start, end);
            ListNode lastEnd = start;
            while (lastEnd.next != null) {
                start = lastEnd.next;
                end = getGroupEnd(start, k);
                if (end == null) {
                    return head;
                }
                reverse(start, end);
                lastEnd.next = end;
                lastEnd = start;
            }
        }
        return head;
    }

    public ListNode getGroupEnd(ListNode start, int k) {
        while (--k > 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    public void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode cur = start;
        ListNode pre = null;
        ListNode next = null;
        while (cur != end) {
            //暂存当前节点的next节点
            next = cur.next;
            //将当前节点的下一个节点指向前一个
            cur.next = pre;
            // 前移pre指针
            pre = cur;
            // 迁移cur指针，继续处理下一个
            cur = next;
        }
        //将当前头节点的下一个节点从null指向组外的第一个节点。
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
        new ReverseNodesInKGroupSjj().reverseKGroup(head, 3);
    }
}
