package com.sjj.mashibing.ChainResponsibility;

public class Client {

    public static void main(String[] args) {
        Handler h1 = new HandlerA();
        Handler h2 = new HandlerB();
        Handler h3 = new HandlerC();
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        RequestData requestData = new RequestData("请求数据ABCDE");
        h1.handle(requestData);
    }
}
