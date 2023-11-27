package com.gem.leetcode;

import com.gem.leetcode.list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/">
 * 142. 环形链表
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee142 {
    public ListNode detectCycle(ListNode head) {
        if(head != null && head.next != null){
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    //快慢指针相遇后，将快指针重定向到起点。
                    fast = head;
                    while (fast != slow) {
                        fast = fast.next;
                        slow = slow.next;
                    }
                    return fast;
                }
            }
        }
        return null;
    }

    public ListNode detectCycle3ms(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{3, 2, 0, -4});
        System.out.println(new Lee142().detectCycle(head));
    }
}
