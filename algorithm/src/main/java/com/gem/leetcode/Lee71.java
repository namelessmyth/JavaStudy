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
public class Lee71 {
    /**
     * <ol>
     *     <li>将原字符按/切分，如果是多个/，中间是""</li>
     *     <li>遍历每一个切分之后的元素，如果是正常的路径字符则加入到栈中</li>
     *     <li>正常的路径字符指的是：非.非空字符，非空格</li>
     *     <li>只要遇到1次".."则将栈的末尾元素弹出1个</li>
     *     <li>遍历栈中的元素，将他们用/加起来</li>
     * </ol>
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equals(name)) {
                //如果出现..就往上返回一级
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.trim().length() > 0 && !".".equals(name)) {
                //过滤非法字符，如果当前路径非空非空格且不等于"."，则记录到栈中。
                stack.offerLast(name);
            }
        }
        StringBuffer ans = new StringBuffer();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }

    public String my(String path) {
        String[] paths = path.split("/");
        Deque<String> stack = new ArrayDeque();
        for (String s : paths) {
            if ("..".equals(s)) {
                stack.pollLast();
            } else if (s.trim().length() > 0 && !".".equals(s)) {
                stack.addLast(s);
            }
        }
        StringBuilder res = new StringBuilder();
        if (stack.isEmpty()) {
            res.append("/");
        } else {
            for (String s : stack) {
                res.append("/").append(s);
            }
        }
        return res.toString();
    }


    public String simplify1ms(String path) {
        List<String> list = new ArrayList<>();
        int len = path.length();
        for (int i = 0; i < len; i++) {
            if (path.charAt(i) != '/') {
                int start = i;
                while (i < len && path.charAt(i) != '/') i++;
                int end = i;
                String name = path.substring(start, end);
                if (name.equals(".")) {
                    continue;
                } else if (name.equals("..")) {
                    if (!list.isEmpty()) {
                        list.remove(list.size() - 1);
                    }
                } else {
                    list.add(name);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            sb.append("/");
            sb.append(item);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Lee71().simplifyPath("/\\/./home/opt/ /./e/ ///"));
    }
}
