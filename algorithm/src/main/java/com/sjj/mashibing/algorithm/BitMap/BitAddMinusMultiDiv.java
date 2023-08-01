package com.sjj.mashibing.algorithm.BitMap;

/**
 * 用位运算实现加减乘除 <br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/2/20
 */
public class BitAddMinusMultiDiv {
    /**
     * 位运算-加法
     */
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            //循环直到进位信息为空
            sum = a ^ b;//无进位相加
            b = (a & b) << 1;//得到进位信息
            a = sum;//将结果给a，继续循环
        }
        return sum;
    }

    /**
     * 位运算-取反
     */
    public static int negNum(int n) {
        return add(~n, 1);
    }

    /**
     * 位运算-减法
     */
    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    /**
     * 位运算-乘法
     */
    public static int multi(int a, int b){
        int result = 0;
        while(b != 0){
            if((b & 1) != 0){//判断最后一位是1还是0
                result = add(result, a);//将结果累加
            }
            a <<= 1;//将a后面补0
            b >>>= 1;//开始下一位的计算
        }
        return result;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negNum(1)) {
                return Integer.MAX_VALUE;
            } else {
                int c = div(add(a, 1), b);
                return add(c, div(minus(a, multi(c, b)), b));
            }
        } else {
            return div(a, b);
        }
    }

    public static void main(String[] args) {
        int a = -4;
        System.out.println(a >> 1);
        System.out.println(a >>> 1);
        System.out.println(multi(-3, 4));
    }
}
