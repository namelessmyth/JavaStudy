package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150">
 * 125. 验证回文串
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee125 {
    /**
     * <ol>
     *     <li>使用正则去掉所有不符合要求的字符，然后转成小写</li>
     *     <li>使用2个指针，一个从前到后，一个从后往前</li>
     *     <li>当2个指针相遇时，如果一直相等那就是回文了</li>
     *     <li>leetcode提交结果29ms，性能较低，应该还是因为正则匹配是通用算法，所以会引入很多额外的判断和分支，导致时间常数偏大。</li>
     * </ol>
     *
     * @return
     */
    public boolean isPalindromeMy(String s) {
        boolean result = false;
        if (s != null && s.length() > 0) {
            s = s.replaceAll("[^a-zA-Z0-9]", "");
            s = s.toLowerCase();
            if (s.length() > 0) {
                int j = s.length() - 1;
                for (int i = 0; i < j; i++) {
                    if (s.charAt(i) != s.charAt(j)) {
                        return false;
                    }
                    j--;
                }
            }
            return true;
        }
        return result;
    }

    /**
     * 以下算法，leetcode执行结果为：2ms，击败 95.88% 使用 Java 的用户
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int i = 0, j = n - 1;
        s = s.toLowerCase();
        while (i < j) {
            if (!isDigit(cs[i])) {
                i++;
            } else if (!isDigit(cs[j])) {
                j--;
            } else {
                if (!equals(cs[i], cs[j])) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isDigit(char c) {
        //return Character.isLetterOrDigit(c);
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }
    static final int DISTANCE = 'a' - 'A';
    private boolean equals(char a, char b) {
        if (a >= '0' && a <= '9'|| b >= '0' && b <= '9') {
            return a == b;
        }
        return a == b || a + DISTANCE == b || a == b + DISTANCE;
    }

    public static void main(String[] args) {
        boolean result = new Lee125().isPalindrome("race a car");
        System.out.println(result);
    }
}
