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
        //根据K找到尾结点，包含开始节点自己。
        ListNode end = getKGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        // 将head指向尾节点，也就是未来的首尾结点
        head = end;
        // 反转首尾节点
        reverse(start, end);
        // 记录上一组的尾节点，为上一组的开始节点，将指向下一组的首节点
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            // 反转首尾节点
            reverse(start, end);
            // 反转结束之后，让上一个区间的尾结点指向这个区间的首结点
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    public static ListNode getKGroupEnd(ListNode start, int k) {
        //实际循环的次数是k-1个，例如：k=2，只要循环1次，因为要包含开始节点
        while (--k != 0 && start != null) {
            //找到尾结点。
            start = start.next;
        }
        return start;
    }

    public static void reverse(ListNode start, ListNode end) {
        //将end更新到下一个节点
        end = end.next;
        //记录上一个节点
        ListNode pre = null;
        //当前节点
        ListNode cur = start;
        //下一个节点
        ListNode next = null;
        //循环直到结束节点的下一个节点。也就是范围外的右节点
        while (cur != end) {
            next = cur.next;
            //将当前节点的next指向上一个，第一个节点指向null
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //最后将开始节点（反转之后就是结束节点）指向下一个区间的第一个节点。
        start.next = end;
    }

    /**
     * <ol>
     *     <li>定义2个子方法，一个是根据k找到尾结点的方法，另一个是反转首尾节点的方法</li>
     *     <li>从第一个节点开始，根据K找到尾结点，如果尾结点为空，则直接返回</li>
     *     <li>反转首尾节点区间内的所有节点，反转后尾节点指向下一个区间的首节点</li>
     *     <li>将上一个区间尾结点指向反转后的首节点，循环处理直到区间下一个节点为空</li>
     * </ol>
     *
     * @return
     */
    public ListNode reverseKGroupMy(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        ListNode start = head;
        ListNode lastEnd = null;
        boolean done = false;
        do {
            //根据K找到尾结点，包含开始节点自己。
            ListNode end = getEnd(start, k);
            if (end == null) {
                //如果找不到尾结点，说明K大于剩余结点数量
                return head;
            }
            //反转首尾节点
            reverseSub(start, end);
            if (!done) {
                //将head指向第一组反转之后的首节点
                head = end;
                done = true;
            }
            if (lastEnd != null) {
                // 反转结束之后，让上一个区间的尾结点指向这个区间的首结点
                lastEnd.next = end;
            }
            lastEnd = start;
            start = start.next;
        } while (start != null);
        return head;
    }

    /**
     * 根据给定的开始节点，返回单链表中往后数的第K个元素
     * @return 如果k大于剩余的节点数将返回null
     */
    public ListNode getEnd(ListNode start, int k) {
        //实际循环的次数是k-1个，例如：k=2，只要循环1次，因为要包含开始节点
        while (--k != 0 && start != null) {
            //找到尾结点。
            start = start.next;
        }
        return start;
    }

    /**
     * 将开始和结束节点反转，逆序重排
     * 反转之后，区间的尾结点会指向下一个区间的首节点。
     */
    public void reverseSub(ListNode start, ListNode end) {
        ListNode right = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        //循环直到结束节点的下一个节点。也就是范围外的右节点
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //最后将开始节点（反转之后就是结束节点）指向下一个区间的第一个节点。
        start.next = right;
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
