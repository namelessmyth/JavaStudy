package com.sjj.mashibing.ChainResponsibility.interfaceHandler;

import com.sjj.mashibing.ChainResponsibility.RequestData;

/**
 * 抽象处理者类（Handler）
 **/
public interface Handler {
    void handle(RequestData requestData, Context context);
}
