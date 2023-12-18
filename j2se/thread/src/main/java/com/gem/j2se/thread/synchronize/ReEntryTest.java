package com.gem.j2se.thread.synchronize;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/17
 */
public class ReEntryTest {
    public static void main(String[] args) {
        ReEntryTest reentrantLockTest = new ReEntryTest();
        reentrantLockTest.method1();
    }

    public synchronized void method1() {
        method2();
        System.out.println("invoke method1");
    }

    public synchronized void method2() {
        System.out.println("invoke method2");
    }
}
