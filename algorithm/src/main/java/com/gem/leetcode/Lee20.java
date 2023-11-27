package com.gem.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses/">
 * 20. 有效的括号
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee20 {
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};


    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.empty() || c != stack.pop())
                return false;
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    public boolean isValid0ms(String s) {
        char[] cs = s.toCharArray();
        char[] stack = new char[cs.length];
        int top = -1;
        for (char c : cs) {
            if (c == '(') {
                stack[++top] = ')';
            } else if (c == '[') {
                stack[++top] = ']';
            } else if (c == '{') {
                stack[++top] = '}';
            } else {
                if (top == -1 || c != stack[top]) {
                    return false;
                }
                top--;
            }
        }
        return top == -1;
    }

    public static void main(String[] args) {
        System.out.println(new Lee20().isValid("{[[]]()}"));
    }
}
