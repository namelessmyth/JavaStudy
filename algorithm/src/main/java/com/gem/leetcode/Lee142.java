package com.gem.leetcode;

import com.gem.leetcode.list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/">
 * 142. 环形链表（中等）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee142 {
    /**
     * <ol>
     *     <li>定义快慢指针，快指针的速度是慢指针的2倍。如果存在环则他们一定会相遇</li>
     *     <li>根据数学公式可以推倒，快指针从出发点到入口的距离和相遇点到入口的距离是相等的。</li>
     *     <li>所以此时让快指针定位到出发点，两个指针用相同速度往前走</li>
     *     <li>他们的相遇点就是入环的节点</li>
     * </ol>
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head != null && head.next != null) {
            //定义快慢指针
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                //快指针一次跑2格，慢指针一次跑1格
                fast = fast.next.next;
                slow = slow.next;
                // 如果存在环，则他们必然会相遇
                if (fast == slow) {
                    //快慢指针相遇后，将快指针重定向到起点。
                    fast = head;
                    //快指针从出发点到入口的距离应该是和慢指针从相遇点到入口的距离相等。
                    while (fast != slow) {
                        //快慢指针用一样的速度走。相遇就代表到达入口
                        fast = fast.next;
                        slow = slow.next;
                    }
                    return fast;
                }
            }
            //走到这里代表链表没有环，快指针先走完。
        }
        return null;
    }

    /**
     * <ol>
     *     <li>使用hashset记录指针走过的每一个节点，注意：不是记录节点的值。</li>
     *     <li>如果链表不存在环，则循环的时候，则一遍就循环完了</li>
     *     <li>如果链表存在环，那一定会循环到一个hastset中已经存在的节点</li>
     *     <li>第一个重复的节点就是入环节点，返回即可</li>
     * </ol>
     * @param head
     * @return
     */
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
