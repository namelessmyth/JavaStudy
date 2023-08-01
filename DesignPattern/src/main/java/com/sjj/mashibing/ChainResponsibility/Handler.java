package com.sjj.mashibing.ChainResponsibility;

/**
 * 抽象处理者类（Handler）
 **/
public abstract class Handler {

    protected Handler successor = null;

    public void setSuccessor(Handler successor){
        this.successor = successor;
    }

    public abstract void handle(RequestData requestData);
}
