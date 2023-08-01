package com.sjj.mashibing.algorithm.bin;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/1/7
 */
public class PrintBin32 {
    public static void print(int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 31; i >= 0; i--) {
            sb.append(((1 << i) & num) == 0 ? "0" : "1");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        print(1);
        print(2);
        print(3);
        print(-1);
        print(Integer.MAX_VALUE);
        print(-5);
    }
}
