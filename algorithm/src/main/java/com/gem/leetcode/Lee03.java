package com.gem.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">
 * 3. 无重复字符的最长子串
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee03 {
    /**
     * <ol>
     *     <a href="https://zhuanlan.zhihu.com/p/136063090">滑动窗口法</a>
     *     <li>用left和right分别代表窗口的左边界和右边界，最大不重复子串的值就是这个窗口能达到的最大值</li>
     *     <li>判断right++处的字符是否在窗口中，如果没有，就加入窗口中，并right+1。</li>
     *     <li>随着right继续增加，我们发现有重复的值在窗口中了，就不断地减少窗口，即令left++，直到窗口中没有重复元素为止（在这之前记录窗口大小曾经达到过的最大值）</li>
     *     <li>重复以上步骤，直至right到头为止。案例（abcabcbb）中窗口的最大值为3，所以返回3。</li>
     * </ol>
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        //记录窗口中出现过的字符
        Set set = new HashSet();
        //窗口最大值，左边界，右边界
        int maxSize = 0, left = 0, right = 0;
        while (left < n && right < n) {
            if (!set.contains(s.charAt(right))) {
                //如果当前字符不在窗口中，则右边界右移扩大窗口并将当前字符加入到窗口字符中。
                set.add(s.charAt(right++));
                //更新窗口最大值
                maxSize = Math.max(maxSize, right - left);
            } else {
                //如果当前字符已经在窗口中，则移除边界字符且左边界右移。
                set.remove(s.charAt(left++));
            }
        }
        return maxSize;
    }

    /**
     * 这种算法思路和上面的一致，但是做了细节优化。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2ms(String s) {
        char[] st = s.toCharArray();
        int n = st.length, maxSize = 0, left = 0;
        //使用char对应的int值作为下标，存储对应的字符是否存在。ascii字符总共128个。
        boolean[] hs = new boolean[128];
        //从左到右依次循环每个字符。
        for (int right = 0; right < n; right++) {
            //右边界字符
            char c = st[right];
            while (hs[c]) {
                //如果当前的右边界字符已经在窗口中存在。则将左边界右移，同时将左边界当前字符从窗口元素中移除。
                //左边界右移需要一直移动到和右边界不相等的字符上。这样可以缩小计算量
                hs[st[left++]] = false;
            }
            //将右边界字符放到窗口元素数组中标记为已存在。
            hs[c] = true;
            //计算目前统计到的不重复字符的最大长度
            maxSize = Math.max(maxSize, right - left + 1);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        System.out.println(new Lee03().lengthOfLongestSubstring2ms("abcabcbb"));
    }
}
