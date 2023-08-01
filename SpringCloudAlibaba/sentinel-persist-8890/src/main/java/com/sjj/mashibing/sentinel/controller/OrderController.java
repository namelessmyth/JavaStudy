package com.sjj.mashibing.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/4/23/0023
 */
@RestController
public class OrderController {
    @GetMapping("/order/test1")
    @SentinelResource(value = "test1")
    public String test1() throws InterruptedException {
        return "test1 ";
    }
}
