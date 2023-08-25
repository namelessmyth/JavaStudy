package com.sjj.mashibing.algorithm.bin;

import cn.hutool.core.date.StopWatch;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class SumFactorialTest {
    StopWatch s = new StopWatch();
    static final int n = 1000000;

    void f1() {
        s.start("SumFactorialTest-f1");
        System.out.println(SumFactorial.f1(900000));
        s.stop();
        System.out.println(s.prettyPrint(TimeUnit.MILLISECONDS));
    }

    @Test
    void f2() {
        s.start("SumFactorialTest-f2");
        System.out.println(SumFactorial.f2(n));
        s.stop();
        System.out.println(s.prettyPrint(TimeUnit.MILLISECONDS));
    }

    @Test
    void f3() {
        s.start("SumFactorialTest-f3");
        System.out.println(SumFactorial.f3(n));
        s.stop();
        System.out.println(s.prettyPrint(TimeUnit.MILLISECONDS));
    }

    void factorial() {
        s.start("SumFactorialTest-f2");
        System.out.println(SumFactorial.factorial(20000));
        System.out.println(Long.MAX_VALUE);
        s.stop();
        System.out.println(s.prettyPrint(TimeUnit.MILLISECONDS));
    }

}