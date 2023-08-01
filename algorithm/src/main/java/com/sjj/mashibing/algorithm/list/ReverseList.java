package com.sjj.mashibing.algorithm.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/2/8
 */
public class ReverseList {
    /**
     * 单链表节点
     */
    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            value = data;
        }
    }

    /**
     * 双链表节点
     */
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int data) {
            value = data;
        }
    }

    /**
     * 单链表反转
     * @param head 链表头引用
     */
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            //1：暂存下节点（b节点）。2：暂存c节点。3.暂存null
            next = head.next;
            //1：将a下节点指向指向null；2：将b指向a；将c指向b。
            head.next = pre;
            //1：pre指向a节点。2：pre指向b节点。3：pre指向c节点
            pre = head;
            //1：将head指向b节点。2：head指向c节点。3：head指向null，结束循环
            head = next;
        }
        //此时pre指向3节点
        return pre;
    }

    /**
     * 双链表反转
     * @param head 链表头引用
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            //1：暂存a的下节点b；2：暂存c节点；3.暂存null
            next = head.next;
            //1：将a下节点指向null；2：将b的下节点指向a；3：将c指向b。
            head.next = pre;
            //1：将a上节点指向b；2：将b指向c；3：将c指向null。
            head.last = next;
            //1：将pre指向a；2：将pre指向b；3：将pre指向c。
            pre = head;
            //1：将head指向b节点。2：head指向c节点。3：head指向null，结束循环
            head = next;
        }
        return pre;
    }

    // for test
    public static Node generateRandomLinkedList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        Node head = new Node((int) (Math.random() * (value + 1)));
        Node pre = head;
        while (size != 0) {
            Node cur = new Node((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    // for test
    public static List<Integer> getLinkedListOriginOrder(Node head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    // for test
    public static boolean checkLinkedListReverse(List<Integer> origin, Node head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // for test
    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTime = 100000;
        System.out.println("test begin!");
        for (int i = 0; i < testTime; i++) {
            Node node1 = generateRandomLinkedList(len, value);
            List<Integer> list1 = getLinkedListOriginOrder(node1);
            node1 = reverseLinkedList(node1);
            if (!checkLinkedListReverse(list1, node1)) {
                System.out.println("Oops1!");
            }
        }
        System.out.println("test finish!");
    }
}
