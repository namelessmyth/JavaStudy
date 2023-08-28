package com.sjj.mashibing.algorithm.bin;

import cn.hutool.core.date.StopWatch;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class PrintBin32Test {
    StopWatch s = new StopWatch();
    static final int n = 100000;

    @Test
    void print() {
        s.start();
        for (int i = 0; i < n; i++) {
            PrintBin32.print(1);
            PrintBin32.print(2);
            PrintBin32.print(3);
            PrintBin32.print(-1);
            PrintBin32.print(Integer.MAX_VALUE);
            PrintBin32.print(-5);
        }
        s.stop();
        System.out.println(s.prettyPrint(TimeUnit.MILLISECONDS));
    }

    @Test
    void printJdk() {
        s.start();
        for (int i = 0; i < n; i++) {
            PrintBin32.printJdk(1);
            PrintBin32.printJdk(2);
            PrintBin32.printJdk(3);
            PrintBin32.printJdk(-1);
            PrintBin32.printJdk(Integer.MAX_VALUE);
            PrintBin32.printJdk(-5);
        }
        s.stop();
        System.out.println(s.prettyPrint(TimeUnit.MILLISECONDS));
    }

    @Test
    void compareTest() {
        s.start();
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int num = r.nextInt(Integer.MAX_VALUE);
            String a = PrintBin32.print(num);
            String b = PrintBin32.printJdk(num);
            if(!a.equals(b)){
                System.out.println(String.format("not equals.num=%s, a=%s, b=%s",num,a,b));
            }
        }
        s.stop();
        System.out.println(s.prettyPrint(TimeUnit.MILLISECONDS));
    }
}