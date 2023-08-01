package com.sjj.mashibing.composite;

/**
 * 抽象根节点
 * 对于客户端而言将针对抽象编程,无需关心其具体子类是容器构件还是叶子构件.
 **/
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract String operation();

    public boolean addChild(Component component) {
        throw new UnsupportedOperationException("addChild not supported!");
    }

    public boolean removeChild(Component component) {
        throw new UnsupportedOperationException("removeChild not supported!");
    }

    public Component getChild(int index) {
        throw new UnsupportedOperationException("getChild not supported!");
    }
}