package com.gem.j2se.thread.synchronize;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/12/9
 */
public class SynchronizedByteCode {
    public synchronized void m1(){
        System.out.println(1);
    }
    public static void main(String[] args) {
        int i = 0;
        //在project文件视图中选中java文件，然后选"view > view bytecode with Jclasslib"
        synchronized (SynchronizedByteCode.class){
            i++;
        }
    }
}
