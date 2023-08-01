package com.sjj.mashibing.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/find-words-that-can-be-formed-by-characters/description/<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/7/28
 */
public class Lee1160 {
    /**
     * <ol>
     *     <li>循环处理词汇表的每一个词汇，使用哈希表统计词汇的字母数量</li>
     *     <li>如果某一个词汇，它的每一个字母都在字母表中存在，且数量小于等于则认为该词汇已经掌握</li>
     *     <li>将当前词汇的总数量累加到返回结果中</li>
     * </ol>
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        if (words != null && words.length > 0 && chars != null && chars.length() > 0) {
            Map<Character, Integer> charMap = getWordMap(chars);
            for (String word : words) {
                Map<Character, Integer> wordMap = getWordMap(word);
                int count = 0;
                boolean isExist = true;
                for (Map.Entry<Character, Integer> e : wordMap.entrySet()) {
                    //词汇中的某个字母必须在字母表中存在且数量小于等于
                    Integer charCount = charMap.get(e.getKey());
                    if (charCount == null) {
                        charCount = 0;
                    }
                    if (charCount < e.getValue()) {
                        isExist = false;
                        break;
                    }
                    count += e.getValue();
                }
                if (isExist) {
                    result += count;
                }
            }
        }
        return result;
    }

    /**
     * <ol>
     *     <li>将输入的词汇转换成哈希表，统计每个字母的数量</li>
     * </ol>
     * @param word String
     * @return
     */
    public Map<Character, Integer> getWordMap(String word) {
        Map<Character, Integer> map = null;
        if (word != null && word.length() > 0) {
            map = new HashMap<>();
            char[] wordChar = word.toCharArray();
            for (char wc : wordChar) {
                Integer c = map.get((Character) wc);
                if (c == null) {
                    c = 0;
                }
                c = c + 1;
                map.put(wc, c);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"look", "kueci", "sjj"};
        System.out.println(new Lee1160().countCharacters(words, "jlodasfdkofsj"));
    }
}
