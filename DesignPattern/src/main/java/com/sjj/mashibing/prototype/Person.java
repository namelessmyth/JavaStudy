package com.sjj.mashibing.prototype;

import cn.hutool.core.clone.Cloneable;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/23
 */
@Data
@ToString
public class Person implements Cloneable, Serializable {
    private String name;
    private Integer age;
    private Person mate;

    @Override
    public Person clone() {
        Person p = null;
        try {
            p = (Person)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
