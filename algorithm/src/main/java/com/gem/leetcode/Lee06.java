package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150">
 * 6. N 字形变换
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee06 {
    /**
     * <a href="https://leetcode.cn/problems/zigzag-conversion/solutions/9106/hua-jie-suan-fa-6-z-zi-xing-bian-huan-by-guanpengc/">
     * 画解算法：6. Z 字形变换（4ms）
     * </a><br>
     */
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            //如果高度为1或者s的字符长度小于高度则直接返回原字符。
            return s;
        }
        int len = Math.min(s.length(), numRows);
        //用于记录每一行的文本。
        StringBuilder[] rows = new StringBuilder[len];
        //y坐标
        int y = 0;
        //true:向下，false:向右
        boolean down = false;
        //循环每一个字符，将其追加到特定的行上。
        for (int i = 0; i < s.length(); i++) {
            if (rows[y] == null) {
                rows[y] = new StringBuilder();
            }
            //在特定的行上追加字符。
            rows[y].append(s.charAt(i));
            if (y == 0 || y == numRows - 1) {
                //循环刚开始时向下，到达指定行数后向右，返回出发点再向下。
                down = !down;
            }
            //如果方向向下则+1，如果向右则-1
            y += down ? 1 : -1;
        }
        //将所有行的字符累加起来就是答案。
        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) {
            ans.append(row);
        }
        return ans.toString();
    }

    public String convert1ms(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] ch = new char[s.length()];
        int index = 0;
        int len = s.length();
        for (int i = 0; i < numRows && i < len; i++) {
            if (i == 0 || i == numRows - 1) {
                //如果是第一行和最后一行
                int m = i;
                while (m < len) {
                    ch[index++] = s.charAt(m);
                    m += (numRows - 1) * 2;
                }
            } else {
                //如果是中间行
                int p = i, q = i + (numRows - i - 1) * 2;
                while (p < len || q < len) {
                    if (p < len) {
                        ch[index++] = s.charAt(p);
                        p += (numRows - 1) * 2;
                    }
                    if (q < len) {
                        ch[index++] = s.charAt(q);
                        q += (numRows - 1) * 2;
                    }
                }
            }
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(new Lee06().convert("PAYPALISHIRING", 4));
    }
}
