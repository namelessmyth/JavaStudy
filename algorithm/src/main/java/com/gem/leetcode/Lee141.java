package com.gem.leetcode;

import com.gem.leetcode.list.ListNode;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle/">
 * 141. 环形链表
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        //慢指针，从起跑线出发
        ListNode slow = head;
        //快指针，从起步线的next出发
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                //如果快指针到达终点或者下一格即将到达终点。这里不需要判断慢指针，因为在没有环的场景下，快指针一定先到达终点。
                return false;
            }
            //慢指针，每次移动1格
            slow = slow.next;
            //快指针，每次移动2格
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{3, 2, 0, -4});
        System.out.println(new Lee141().hasCycle(head));
    }
}
