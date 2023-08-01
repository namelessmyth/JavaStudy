package com.sjj.mashibing.algorithm.list;

/**
 * 将2个链表对应节点的值相加<br>
 * <a href="https://leetcode.cn/problems/add-two-numbers/">leetcode题目链接</a><br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/2/10
 */
public class MergeTwoLists {
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
     * @param l1 链表1头节点
     * @param l2 链表2头节点
     * @return 重排之后新的单链表的头元素
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //任何一个为空，直接返回不做处理。
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        //比较头节点大小，小的作为返回值头节点
        ListNode head = l1.val <= l2.val ? l1 : l2;

        ListNode small = head;
        ListNode big = head == l1 ? l2 : l1;

        ListNode pre = small;
        ListNode cur1 = small.next;//cur1从小链表的第2个开始
        ListNode cur2 = big;//cur2从大链表的第1个开始
        while (cur1 != null && cur2 != null) {
            //谁小指向谁，谁小谁往前进
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        //循环完了之后，pre停在某个链表的尾部需要链接上另一个
        pre.next = cur1 == null? cur2:cur1;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(10);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(9);

        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode result = new MergeTwoLists().mergeTwoLists(node1, node4);
        System.out.println(result);
    }
}
