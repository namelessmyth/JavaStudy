package com.gem.leetcode;

import com.gem.leetcode.list.ListNode;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/sort-list/">
 * 148. 排序链表（中等）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee148 {
    /**
     * 注意：这个方法是用空间换的时间。虽然速度能够达到2ms，但空间复杂度比较高。
     * <ol>
     *     <li>第1次循环，找到链表的最大值和最小值，构建一个数组，大小为最大值-最小值+1</li>
     *     <li>第2次循环，在数组中记录每一个数值出现的次数，数组下标为：节点的值-最小值</li>
     *     <li>第3次循环，循环数组，只要当前数组值大于0就修改链表当前个节点的值</li>
     *     <li>改完之后，数组当前值-1，链表跳到下一个节点，直到当前值为0，继续数组下一个值。</li>
     * </ol>
     */
    public ListNode sortList(ListNode head) {
        ListNode temp = head;
        //定义最大值和最小值
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (temp != null) {
            //循环并从链表中更新最大和最小值
            min = Math.min(min, temp.val);
            max = Math.max(max, temp.val);
            temp = temp.next;
        }
        temp = head;
        //例如：最大值是10，最小值是2，那这个链表里面可能出现的数值最多是9种
        int size = max - min + 1;
        int[] counter = new int[size];
        while (temp != null) {
            //再次循环统计每一个数值出现的个数
            counter[temp.val - min]++;
            temp = temp.next;
        }
        temp = head;
        //创建虚拟空节点
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int i = 0; i < size; i++) {
            //根据刚才统计出来的，每个数值出现的次数，再次循环。去修改链表中每个节点的值
            while (counter[i] != 0) {
                //如果某个数出现了多次就循环多次。
                temp.val = i + min;
                cur.next = temp;
                temp = temp.next;
                cur = cur.next;
                counter[i]--;
            }
        }
        return dummy.next;
    }

    public ListNode my(ListNode head) {
        //定义最大值和最小值
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        //第1次循环，找到链表的最大值和最小值，构建一个数组，大小为最大值-最小值+1
        ListNode temp = head;
        while (temp != null) {
            max = Math.max(temp.val, max);
            min = Math.min(temp.val, min);
            temp = temp.next;
        }
        //第2次循环，在数组中记录每一个数值出现的次数，数组下标为：节点的值-最小值
        int[] count = new int[max - min + 1];
        temp = head;
        while (temp != null) {
            count[temp.val - min]++;
            temp = temp.next;
        }
        //第3次循环，循环数组，只要当前数组值大于0就修改链表当前个节点的值
        temp = head;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                //改完之后，数组当前值-1，链表跳到下一个节点，直到当前值为0，继续数组下一个值。
                temp.val = i + min;
                temp = temp.next;
                count[i]--;
            }
        }
        return head;
    }

    /**
     * 将入参链表转换成ArrayList，使用jdk自带方法排序
     */
    public ListNode sortList12ms(ListNode head) {
        if (head == null) {
            return head;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        Collections.sort(list, (node1, node2) -> node1.val - node2.val);
        ListNode res = new ListNode(0);
        for (ListNode node : list) {
            res.next = node;
            res = res.next;
        }
        res.next = null;
        return list.get(0);
    }

    public ListNode myList(ListNode head) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(list);
        temp = head;
        for (Integer i : list) {
            temp.val = i;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{-1, 5, 3, 4, 0});
        System.out.println(new Lee148().my(head));
    }
}
