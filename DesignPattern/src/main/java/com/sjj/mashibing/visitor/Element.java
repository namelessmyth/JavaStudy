package com.sjj.mashibing.visitor;

/**
 * 抽象元素有两类方法，
 * 一是本身的业务逻辑，也就是元素作为一个业务处理单元必须完成的职责;
 * 另外一个是允许哪一个访问者来访问。这里只声明的第二类即accept方法。
 */
public interface Element {
    void accept(Visitor visitor);
}