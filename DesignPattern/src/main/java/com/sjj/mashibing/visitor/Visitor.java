package com.sjj.mashibing.visitor;

/**
 * 此处可为抽象类或接口，用于声明访问者可以访问哪些元素。
 * 具体到程序中就是visit方法的参数定义哪些对象是可以被访问的。
 */
public interface Visitor {
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}
