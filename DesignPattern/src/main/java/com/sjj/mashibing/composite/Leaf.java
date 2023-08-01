package com.sjj.mashibing.composite;

/**
 * 叶子节点：叶子节点中不包含子节点
 **/
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public String operation() {
        return this.name;
    }
}