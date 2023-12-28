package com.gem.leetcode;

import com.gem.leetcode.list.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/">
 * 148. 排序链表（中等）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee148 {
    /**
     * 注意：这个方法是用空间换的时间。虽然速度能够达到2ms，但空间复杂度比较高。55.12MB, 击败24.78%使用 Java 的用户
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

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{3, 2, 0, -4});
        System.out.println(new Lee148().sortList(head));
    }
}
