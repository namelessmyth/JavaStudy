package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150">
 * 151. 反转字符串中的单词
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee151 {

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        if (s != null && s.length() > 0) {
            s = s.trim();
            int end = s.length();
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == ' ' && s.charAt(i + 1) != ' ') {
                    result.append(s.substring(i + 1, end).trim()).append(' ');
                    end = i;
                }
            }
            result.append(s.substring(0, end).trim());
        }
        return result + "";
    }

    public static void main(String[] args) {
        System.out.println(new Lee151().reverseWords("a good   example"));
    }
}
