package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/roman-to-integer/description/?envType=study-plan-v2&envId=top-interview-150">
 * 13. 罗马数字转整数
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee13 {
    /**
     * <ol>
     *     <li>依次遍历入参字符窜中的每个字符，将其按照题目给的规则转换成int</li>
     *     <li>将每一个字符代表的值累加起来就是结果。累加的时候需要识别出顺序，如果小的在大的前面就要取负数。</li>
     *     <li>定义前一个值和当前值，如果当前值比上一个值大，那就把上一个值取负累加到结果中</li>
     * </ol>
     * @return
     */
    public int romanToInt(String s) {
        int result = 0;
        if (s != null && s.trim().length() > 0) {
            char[] charArray = s.toCharArray();
            int previous = getInt(charArray[0]);
            int current = -1;
            for (int i = 1; i < charArray.length; i++) {
                current = getInt(charArray[i]);
                if (current > previous) {
                    result -= previous;
                } else {
                    result += previous;
                }
                //计算完了之后当前值就是上一个值。用于下次循环。
                previous = current;
            }
            //数组最后一个数，不用判断正负，直接加上
            result += previous;
        }
        return result;
    }

    private int getInt(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String input = "MCMXCIV";
        int result = new Lee13().romanToInt(input);
        System.out.println(result);
    }
}
