package com.sjj.mashibing.state;

public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        State state1 = new ConcreteStateA();
        state1.handle(context);
        System.out.println(context);
        System.out.println("========================");

        State state2 = new ConcreteStateB();
        state2.handle(context);
        System.out.println(context.getCurrentState().toString());
    }
}
