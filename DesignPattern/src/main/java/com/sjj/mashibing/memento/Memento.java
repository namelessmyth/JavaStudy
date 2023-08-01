package com.sjj.mashibing.memento;

import lombok.Data;

/**
 * 备忘录对象
 *     访问权限为: 默认,也就是同包下可见(保证只有发起者类可以访问备忘录类)
 **/
@Data
class Memento {

    private String state = "从备份对象恢复为原始对象";
    private String id;
    private String name;
    private String phone;

    public Memento() {
    }

    public Memento(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}