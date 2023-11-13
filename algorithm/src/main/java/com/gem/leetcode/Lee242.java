package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/valid-anagram/">
 * 242. 有效的字母异位词
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee242 {
    /**
     * <ol>
     *     <a href="https://leetcode.cn/problems/valid-anagram/solutions/6690/hua-jie-suan-fa-242-you-xiao-de-zi-mu-yi-wei-ci-by/?envType=study-plan-v2&envId=top-interview-150">数组映射</a>
     * </ol>
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] map = new int[26];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            map[sc[i] - 'a']++;
            map[tc[i] - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Lee242().isAnagram("anagram", "naaaram"));
    }
}
