package com.sjj.mashibing.ChainResponsibility.interfaceHandler;

import cn.hutool.core.collection.CollUtil;

import java.util.List;

/**
 * 负责得到职责链的下一个处理器<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/4/6/0006
 */
public class Context {
    List<Handler> list;
    Integer currentIndex;

    public Context(List<Handler> list, Integer currentIndex) {
        this.list = list;
        this.currentIndex = currentIndex;
    }

    public Handler getNext() {
        Handler next = null;
        if (CollUtil.isNotEmpty(list) && currentIndex == null) {
            if (currentIndex == null) {
                currentIndex = 0;
            }
            next = list.get(currentIndex++);
        }
        return next;
    }
}
