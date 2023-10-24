package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150">
 * 12. 整数转罗马数字
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee12 {
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int num) {
        if(num > 3999 || num < 1){
            //根据题目意思：1 <= num <= 3999
            return null;
        }
        StringBuilder roman = new StringBuilder();
        //计算千位上的数
        roman.append(thousands[num / 1000]);
        //计算百位上的数
        roman.append(hundreds[num % 1000 / 100]);
        //计算十位上的数
        roman.append(tens[num % 100 / 10]);
        //计算个位上的数
        roman.append(ones[num % 10]);
        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Lee12().intToRoman(1994));
    }
}
