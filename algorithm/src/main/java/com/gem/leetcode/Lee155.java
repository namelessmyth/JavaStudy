package com.gem.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/simplify-path/">
 * 71. 简化路径（中等）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee155 {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.pop();
        int param3 = obj.top();
        int param4 = obj.getMin();
        System.out.println(param3 + "," + param4);
    }
}

class MinStack {
    private Node node;

    public MinStack() {
    }

    public void push(int val) {
        if (node == null) {
            node = new Node(val, val, null);
        } else {
            //创建一个新的节点next指向老的节点，同时当前node为这个新的节点
            //每次放入都计算一下，当前值是否是最小，不是则更新，所以最后节点记录的一定是最小值。
            node = new Node(val, Math.min(node.min, val), node);
        }
    }

    public void pop() {
        //指针指向前一个节点，上一个节点由于不再有GC root对象指向他，会被垃圾回收
        node = node.next;
    }

    public int top() {
        return node.val;
    }

    public int getMin() {
        return node.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * 这个实现性能太低，498ms
 * 击败5.03%使用 Java 的用户
 */
class MinStackMy {
    LinkedList<Integer> list;

    public MinStackMy() {
        list = new LinkedList<>();
    }

    public void push(int val) {
        list.add(val);
    }

    public void pop() {
        list.removeLast();
    }

    public int top() {
        return list.getLast();
    }

    public int getMin() {
        return Collections.min(list);
    }
}
