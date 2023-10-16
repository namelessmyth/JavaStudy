package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150">
 * 392. 判断子序列
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee392 {
    /**
     * <ol>
     *     <li>给定字符串 s 和 t ，判断 s 是否为 t 的子序列。</li>
     *     <li>设置双指针 i , j 分别指向字符串 s , t 的首个字符，遍历字符串 t</li>
     *     <li>当 s[i] == t[j] 时，代表匹配成功，此时同时 i++ , j++ </li>
     *     <li>若 i 已走过 s 尾部，代表 s 是 t 的子序列，此时应提前返回 true ；</li>
     * </ol>
     *
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (t == null || s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        for (int i = 0, j = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                // 若已经遍历完 s ，则提前返回 true
                if (i == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean result = new Lee392().isSubsequence("ad34bkdc", "abc");
        System.out.println(result);
    }
}
