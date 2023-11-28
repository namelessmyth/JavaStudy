package com.gem.leetcode;

import com.gem.leetcode.list.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">
 * 21. 合并两个有序链表
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee21 {
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val <= list2.val) {
            //左边更小，将小作为基，指向接下来递归调用之后的小节点
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            //右边更小，将小作为基，指向接下来递归调用之后的小节点
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Lee21().mergeTwoLists(new ListNode(1), new ListNode(3)));
    }
}
