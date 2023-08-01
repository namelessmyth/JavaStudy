package com.sjj.mashibing.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/1/30
 */
@RestController
public class DemoController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/test")
    public String getServerPort() {
        return "Hello Nacos Discovery: " + serverPort;
    }
}
