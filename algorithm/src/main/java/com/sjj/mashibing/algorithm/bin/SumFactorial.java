package com.sjj.mashibing.algorithm.bin;

/**
 * 阶乘之和，给定一个参数N，求1!+2!+3!+......N!的结果<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/1/11
 */
public class SumFactorial {

    public static long f1(int n) {
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result += factorial(i);
        }
        return result;
    }


    public static long f2(int n) {
        long result = 0;
        long temp = 1;
        for (int i = 1; i <= n; i++) {
            temp = temp * i;
            result = result + temp;
        }
        return result;
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    /**
     * @param n
     * @author namelessmyth
     * @return
     */
    public static long f3(int n) {
        long result = 0L;
        long temp = 1L;
        for (int i = 1; i <= n; i++) {
            temp *= i;
            result += temp;
        }
        return result;
    }

    public static void main(String[] args) {
        //见单元测试SumFactorialTest
    }
}
