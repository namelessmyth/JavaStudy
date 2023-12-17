package com.gem.j2se.thread.exception;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/17
 */
public class UncaughtExceptionHandlerTest implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(String.format("线程：%s，异常：%s", t.getName(), e));
    }

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            throw new RuntimeException("线程异常");
        });
        t.setUncaughtExceptionHandler(new UncaughtExceptionHandlerTest());
        t.start();
    }
}
