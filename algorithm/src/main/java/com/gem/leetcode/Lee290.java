package com.gem.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/word-pattern/">
 * 290. 单词规律-简单
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee290 {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (split.length != pattern.length()) {
            //如果按空格拆分后的字符数量和pattern的不一致，直接返回false
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            String str = map.get(pattern.charAt(i));
            if (str != null) {
                if (!str.equals(split[i])) {
                    //如果之前已经放入过且放入的和s中的对应部分不一致
                    return false;
                }
            } else {
                if (map.containsValue(split[i])) {
                    //反方向检查，是否存在一个value对应2个key的情况。
                    //例如：pattern="abba"，s="dog dog dog dog"
                    return false;
                } else {
                    //如果没放过，则放入用于后续比对
                    map.put(pattern.charAt(i), split[i]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Lee290().wordPattern("abba", "dog cat cat dog"));
    }
}
