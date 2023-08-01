package com.sjj.mashibing.memento;

/**
 * 发起人类
 **/
public class Originator {

    private String state = "原始对象";
    private String id;
    private String name;
    private String phone;

    public Originator() {
    }

    //创建备忘录对象
    public Memento create(){
        return new Memento(id,name,phone);
    }

    //恢复对象状态
    public void restore(Memento m){
        this.state = m.getState();
        this.id = m.getId();
        this.name = m.getName();
        this.phone = m.getPhone();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Originator{" +
                "state='" + state + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}