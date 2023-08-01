package com.sjj.mashibing.Singleton.session;

import com.sjj.mashibing.Singleton.SingletonEnumLasy;
import com.sjj.mashibing.adapter.clazz.Computer;

/**
 * 测试在多线程环境下，普通懒汉单例是否线程安全<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/29
 */
public class ISessionUtilThreadSafeTest implements Runnable {

    @Override
    public void run() {
        IAgileSession instance = ISessionUtil.session.getAdmin();
        System.out.println(instance);
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new ISessionUtilThreadSafeTest());
        Thread t2 = new Thread(new ISessionUtilThreadSafeTest());
        Thread t3 = new Thread(new ISessionUtilThreadSafeTest());
        t1.start();
        t2.start();
        t3.start();
    }
}
