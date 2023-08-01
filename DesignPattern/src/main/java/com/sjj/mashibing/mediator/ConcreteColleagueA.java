package com.sjj.mashibing.mediator;

/**
 * 具体同事类
 **/
public class ConcreteColleagueA extends Colleague {

    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void exec(String key) {
        System.out.println("====在组件A中,通过中介者执行!");
        getMediator().apply(key);
    }
}
