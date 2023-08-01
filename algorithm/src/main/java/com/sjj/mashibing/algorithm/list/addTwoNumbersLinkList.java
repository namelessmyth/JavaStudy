package com.sjj.mashibing.algorithm.list;

/**
 * 将2个链表对应节点的值相加<br>
 * <a href="https://leetcode.cn/problems/add-two-numbers/">leetcode题目链接</a><br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/2/10
 */
public class addTwoNumbersLinkList {
    /**
     * 此类为单链表的节点，是题目的前置条件，不用提交。
     */
    public static class ListNode {
        public int val;
        public ListNode next;
        ListNode() {}
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //任何一个为空，直接返回不做处理。
        if (l1 == null && l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //得到每个链表的长度
        int s1 = getListSize(l1);
        int s2 = getListSize(l2);
        //判断长链表和短链表
        ListNode l = s1 >= s2 ? l1 : l2;
        ListNode s = l == l2 ? l1 : l2;

        ListNode head = l;//这个指针用于结果返回。等会循环之后，l会变所有不能用l
        int carry = 0;//进位
        while (l != null) {
            //同时获取2个链表的当前节点的值，短的需要判空。
            int v1 = l.val;
            int v2 = s == null ? 0 : s.val;

            v1 = v1 + v2 + carry; //求和
            carry = v1 / 10; //进位信息
            l.val = v1 % 10; //取余之后才是新的值

            if(l.next == null && carry > 0){
                //如果循环到最后一个，进位大于0，则补一个节点1
                l.next = new ListNode(1);
                return head;
            }
            l = l.next;
            //继续处理下一个，短的那个需要判断一下是否为空。
            if (s != null) {
                s = s.next == null ? null : s.next;
            }
        }
        return head;
    }

    public int getListSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);

        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode result = new addTwoNumbersLinkList().addTwoNumbers(node1, node4);
        System.out.println(result);
    }
}
