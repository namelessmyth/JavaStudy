package com.sjj.mashibing.ChainResponsibility;

/**
 * 处理者要处理的数据
 **/
public class RequestData {
    private String data;

    public RequestData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
