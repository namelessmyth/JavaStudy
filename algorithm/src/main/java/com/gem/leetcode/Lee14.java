package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150">
 * 14. 最长公共前缀
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee14 {
    /**
     * <ol>
     *     <li></li>
     * </ol>
     *
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs != null && strs.length > 0) {
            result = strs[0];
            for (int i = 1; i < strs.length; i++) {
                result = commonString(strs[i], result);
                if(result.length() == 0){
                    break;
                }
            }
        }
        return result;
    }

    private String commonString(String str, String result) {
        String r = null;
        int n = Math.min(str.length(), result.length());
        int i = 0;
        for (i = 0; i < n; i++) {
            if (result.charAt(i) != str.charAt(i)) {
                break;
            }
        }
        r = str.substring(0, i);
        return r;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"flower", "flow", "flight"};
        String result = new Lee14().longestCommonPrefix(input);
        System.out.println(result);
    }
}
