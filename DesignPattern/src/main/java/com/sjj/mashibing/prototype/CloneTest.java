package com.sjj.mashibing.prototype;

import cn.hutool.core.util.ObjectUtil;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/23
 */
public class CloneTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(18);
        p.setName("zhangsan");
        p.setMate(new Person());

        Person p2 = p.clone();
        System.out.println(p == p2);
        System.out.println(p.getMate() == p2.getMate());

        Person p3 = ObjectUtil.cloneByStream(p);
        System.out.println(p == p3);
        System.out.println(p.getMate() == p3.getMate());
    }
}
