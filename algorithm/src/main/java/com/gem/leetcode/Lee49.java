package com.gem.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/group-anagrams/">
 * 49. 字母异位词分组
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            //value这边要放原始字符窜。
            value.add(str);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(new Lee49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
