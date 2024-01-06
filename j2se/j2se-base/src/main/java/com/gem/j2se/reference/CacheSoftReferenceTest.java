package com.gem.j2se.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 使用软引用实现<br>
 * 建议使用如下参数来执行本案例：-Xmx60m -XX:+PrintCommandLineFlags -Xloggc:gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2024/1/6
 */
public class CacheSoftReferenceTest {
    public static void main(String[] args) throws Exception {
        System.out.println("开始执行：" + new Date());
        // 模拟缓存
        Map<Integer, SoftRefedStudent> map = new HashMap<Integer, SoftRefedStudent>();
        // 引用队列，存放软引用
        ReferenceQueue<Student> queue = new ReferenceQueue<Student>();
        for (int i = 0; i < 1000000; i++) {
            //创建很多个对象放入map中，模拟内存满的场景。
            Student p = new Student();
            map.put(i, new SoftRefedStudent(i, p, queue));
            //这个方法在内存没满还没开始回收的时候，返回的是空。
            SoftRefedStudent pollref = (SoftRefedStudent) queue.poll();
            //如果不为空，说明gc开始回收了，返回的是回收时的头对象。
            if (pollref != null) {
                //找出被软引用回收的对象，以key为标志，从map中移除
                System.out.println(new Date() + "回收对象：" + pollref.key);
                //从缓存中移除软引用。
                map.remove(pollref.key);

                Iterator<Map.Entry<Integer, SoftRefedStudent>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = iterator.next();
                    if ((int) entry.getKey() == pollref.key) {
                        System.out.println("见鬼了居然还在：" + pollref.key);
                    }
                }
                System.out.println(i + "第2轮=====" + new Date());
            }
        }
        System.out.println("done");
    }
}

class Student {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class SoftRefedStudent extends SoftReference<Student> {
    public int key;

    /**
     * 当Student对象被回收后，SoftRefedStudent对象会被加入到queue中。
     * 第3个参数叫做ReferenceQueue，是用来存储封装的待回收Reference对象的
     */
    public SoftRefedStudent(int key, Student referent, ReferenceQueue<Student> q) {
        super(referent, q);
        this.key = key;
    }
}
