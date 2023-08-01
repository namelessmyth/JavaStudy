package com.sjj.mashibing.sentinel.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sjj.mashibing.sentinel.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class FlowLimitController {
    @Autowired
    TestService testService;

    @GetMapping("/testA")
    public String testA() {
        return "-----testA";
    }

    @GetMapping("/testB")
    @SentinelResource(value = "testB", blockHandlerClass = {MyBlockHandler.class}, blockHandler = "handlerException1")
    public String testB() {
        return "-----testB";
    }

    @GetMapping("/testC")
    public String testC() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return "-----testC";
    }

    /* 测试链路规则 */
    @GetMapping("/testD")
    public String testD() {
        return testService.common();
    }

    @GetMapping("/testE")
    public String testE() {
        return testService.common();
    }

    /* 测试排队等待 */
    @GetMapping("/testF")
    public String testF() {
        String msg = Thread.currentThread().getName() + "：testF";
        log.info(msg);
        return msg;
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "blockHandler")
    public String testHotKey(@RequestParam(value = "hot1", required = false) String hot1,
                             @RequestParam(value = "hot2", required = false) String hot2,
                             @RequestParam(value = "hot3", required = false) String hot3) {
        return StrUtil.format("testHotKey, hot1:{}, hot2:{}, hot3:{}。", hot1, hot2, hot3);
    }

    //处理异常方法，方法签名要和对应的接口方法保持一致
    public String blockHandler(String hot1, String hot2, String hot3, BlockException exception) {
        return StrUtil.format("您请求的数据访问人数过多，请稍后再试。hot1:{}, hot2:{}, hot3:{}。", hot1, hot2, hot3);
    }

    @GetMapping("/testHandlerClass")
    @SentinelResource(value = "testHandlerClass", blockHandlerClass = {MyBlockHandler.class}, blockHandler = "handlerException1")
    public String testHandlerClass() {
        return "-----testHandlerClass";
    }
}