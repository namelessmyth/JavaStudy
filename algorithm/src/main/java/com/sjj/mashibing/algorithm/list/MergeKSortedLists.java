package com.sjj.mashibing.algorithm.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/2/27
 */
public class MergeKSortedLists {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static class ListNodeComparator implements Comparator<ListNode> {
        /**
         * 默认按照权重升序排列，即权重小的排在前面，权重大的排在后面。<br>
         * 反正负数代表，前面的数权重小。返回0代表相等。返回正数代表后面的数权重大。
         * @param o1 前面的数，
         * @param o2 后面的数
         */
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                // 将入参中每个链表的头结点放入到优先级队列中
                heap.add(lists[i]);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        //先弹出最小的头结点
        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next != null) {
            //将这个头结点的下一个节点也放入优先级队列中
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            //弹出队列中的最小值
            ListNode cur = heap.poll();
            //将之前弹出去的节点的next指向这个最小值
            pre.next = cur;
            //将当前的这个节点作为前一个节点。
            pre = cur;
            if (cur.next != null) {
                //将当前节点的next继续放入队列
                heap.add(cur.next);
            }
        }
        return head;
    }
}
