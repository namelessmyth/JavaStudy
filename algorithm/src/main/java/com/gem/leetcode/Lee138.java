package com.gem.leetcode;

import com.gem.leetcode.list.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/copy-list-with-random-pointer/">
 * 138. 随机链表的复制（中等）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee138 {
    Map<Node, Node> cache = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        //优先去缓存中读取。
        Node node = cache.get(head);
        if (node == null) {
            node = new Node(head.val);
            //将老的和新的建立关联。
            cache.put(head, node);
            //下一格和随机的都递归调用相同方法
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return node;
    }

    public static void main(String[] args) {
        System.out.println(new Lee138().copyRandomList(new Node(new int[]{1, 2, 3})));
    }
}
