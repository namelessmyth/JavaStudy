package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150">
 * 58. 最后一个单词的长度
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee58 {
    /**
     * <ol>
     *     <li>将字符串按空格切割，输出最后一段字符的长度</li>
     * </ol>
     *
     * @return
     */
    public int lengthOfLastWord(String s) {
        int result = 0;
        if (s != null && s.trim().length() > 0) {
            String[] array = s.split(" ");
            result = array[array.length - 1].length();
        }
        return result;
    }

    /**
     * <ol>
     *     <li>从右向左遍历，从第一个不是空格的字符开始计数，一旦开始计数，再遇到空格就结束了</li>
     * </ol>
     *
     * @return
     */
    public int offial(String s) {
        int result = 0;
        if (s != null && s.trim().length() > 0) {
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == ' ') {
                    if (result == 0) {
                        //第1次遇到空格时先不计算
                        continue;
                    }
                    //第2次再遇到空格时就退出循环。
                    break;
                }
                //遇到非空格字符则开始计数。
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "   fly  me   to   the moon   ";
        int result = new Lee58().lengthOfLastWord(input);
        System.out.println(result);
    }
}
