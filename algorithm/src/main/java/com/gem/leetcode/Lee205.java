package com.gem.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150">
 * 205. 同构字符串
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee205 {
    /**
     * <ol>
     *     <li>给定两个字符串 s 和 t ，判断它们是否是同构的</li>
     * </ol>
     *
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> st = new HashMap<>();
        Map<Character, Character> ts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            Character sv = st.get(sc);
            Character tv = ts.get(tc);
            if ((sv != null && sv != tc) || (tv != null && tv != sc)) {
                return false;
            }
            st.put(sc, tc);
            ts.put(tc, sc);
        }
        return true;
    }

    public boolean isIsomorphicFastest(String s, String t) {
        //ASCII 总共128个单字节字符
        int[] asc = new int[128];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i < 128; i++) {
            asc[i] = -1;
        }
        for (int i = 0; i < sc.length; i++) {
            //将char自动转换成int比对这个位置上是否有值
            if (asc[sc[i]] == -1) {
                //如果左边的值在数组中没有对应。
                for (int j = 0; j < 128; j++) {
                    if (asc[j] == tc[i]) {
                        //如果右边的值在数组中已经对应过了
                        return false;
                    }
                }
                asc[sc[i]] = tc[i];
            } else if (asc[sc[i]] != tc[i]) {
                //如果左边的值有对应且和之前存得值不一致
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new Lee205().isIsomorphicFastest("badc", "baba");
        System.out.println(result);
    }
}
