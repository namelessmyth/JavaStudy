package com.sjj.mashibing.visitor;

/**
 * 具体访问者，当访问到一个类后该干什么、怎么千。
 */
public class ConcreteVisitorA implements Visitor {
    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者A访问-->" + element.operationA());
    }
    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者A访问-->" + element.operationB());
    }
}