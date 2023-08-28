package com.sjj.mashibing.algorithm.bin;

import cn.hutool.core.util.StrUtil;

/**
 * 打印任意整数的32位信息<br>
 * 例如：输入1，打印00000000000000000000000000000001
 * 例如：输入2，打印00000000000000000000000000000010
 * 例如：输入3，打印00000000000000000000000000000011
 * @author namelessmyth
 * @version 1.0
 * @date 2023/1/7
 */
public class PrintBin32 {
    public static String print(int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 31; i >= 0; i--) {
            sb.append(((1 << i) & num) == 0 ? "0" : "1");
        }
        System.out.println(sb);
        return sb.toString();
    }

    public static String printJdk(int num) {
        String r = StrUtil.padPre(Integer.toBinaryString(num), 32, "0");
        System.out.println(r);
        return r;
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
