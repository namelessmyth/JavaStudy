package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150">
 * 383. 赎金信
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee383 {
    /**
     * <ol>
     *     <li>给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。</li>
     * </ol>
     *
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean transcribe(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] a = new int[26];
        for (char c : magazine.toCharArray()) {
            a[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            a[c - 'a']--;
            if (a[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new Lee383().canConstruct("aa", "aab");
        System.out.println(result);
    }
}
