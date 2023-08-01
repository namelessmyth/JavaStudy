package com.sjj.mashibing.sentinel.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * Sentinel阻塞处理器<br>
 */
public class MyBlockHandler {
    public static String handlerException1(BlockException exception){
        return "handlerException1：系统异常，请稍后重试！";
    }
    public static String handlerException2(BlockException exception){
        return "handlerException2：网络崩溃了，请稍后重试！";
    }
}
