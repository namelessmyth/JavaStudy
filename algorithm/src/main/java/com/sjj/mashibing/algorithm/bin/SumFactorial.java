package com.sjj.mashibing.algorithm.bin;

/**
 * 给定一个参数N，求1!+2!+3!+......N!的结果<br>
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

    private static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
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

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(f1(200000));
        long end = System.currentTimeMillis();
        System.out.println("f1.time:" + (end - start));

        System.out.println(f2(200000));
        System.out.println("f2.time:" + (System.currentTimeMillis() - end));
    }
}
