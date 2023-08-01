package com.sjj.mashibing.ChainResponsibility.interfaceHandler;

import com.sjj.mashibing.ChainResponsibility.RequestData;

import java.util.LinkedList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        Handler h1 = new HandlerA();
        Handler h2 = new HandlerB();
        Handler h3 = new HandlerC();
        List<Handler> list = new LinkedList<>();
        list.add(h1);
        list.add(h2);
        list.add(h3);

        RequestData requestData = new RequestData("请求数据ABCDE");
        h1.handle(requestData, new Context(list,0));
    }
}
