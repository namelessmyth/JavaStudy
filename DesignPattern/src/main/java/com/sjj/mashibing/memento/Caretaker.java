package com.sjj.mashibing.memento;

/**
 * 负责人类-保存备忘录对象
 **/
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
