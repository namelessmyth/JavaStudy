package com.gem.springboot.thread.controller;

import com.gem.springboot.thread.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/10/14
 */
@RestController
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @RequestMapping("/test")
    public String test() throws InterruptedException {
        asyncService.task1();
        asyncService.task2();
        asyncService.task3();
        return "success";
    }
}
