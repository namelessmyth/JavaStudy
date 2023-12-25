package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/palindrome-number/">
 * 9. 回文数 （回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。）
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee09 {
    /**
     * <ol>
     *     左右指针法,执行用时:6ms
     *     <li>对于负数或者10的倍数直接返回false</li>
     *     <li>将数字转成字符数组，然后用左右指针遍历</li>
     *     <li>左指针从左往右遍历，右指针从右往左遍历，如果每个字符都相等就是回文数</li>
     *     <li>只要有一个不是则返回false</li>
     * </ol>
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        char[] ca = String.valueOf(x).toCharArray();
        if (ca.length > 1) {
            int left = 0;
            int right = ca.length - 1;
            while (left < right) {
                if (ca[left++] != ca[right--]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * <ol>
     *     反转一半数字,执行用时:4ms
     *     <li>将后一半的数字反转，如果和前半段相等就是回文数</li>
     * </ol>
     */
    public boolean isPalindrome5ms(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        //反转x的一半，如果数字长度为奇数时，会超过一半
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public int revert(int x) {
        int result = 0;
        while (x > result) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Lee09().isPalindrome5ms(12345));
    }
}
