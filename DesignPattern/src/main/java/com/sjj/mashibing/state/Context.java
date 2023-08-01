package com.sjj.mashibing.state;

import lombok.Data;
import lombok.ToString;

/**
 * 上下文类
 **/
@ToString
public class Context {

    private State currentState; //维持一个对状态对象的引用

    public Context() {
        this.currentState = null;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
