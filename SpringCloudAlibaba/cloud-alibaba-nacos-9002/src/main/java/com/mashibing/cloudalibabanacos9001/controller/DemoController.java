package com.mashibing.cloudalibabanacos9001.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msb")
public class DemoController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/get")
    public String getServerPort() {
        return "库存-1：" + serverPort;
    }

    @GetMapping(value = "/custom")
    public String customTest() {
        return "网关配置测试~~costom";
    }
}
