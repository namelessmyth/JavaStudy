package com.sjj.mashibing.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/1/30
 */
@RestController
public class DemoController {
    /**
     * 消费者去访问具体服务，这种写法可以实现
     * 配置文件和代码的分离
     */
    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/test")
    public String getServerPort() {
        return "Hello Nacos Discovery: " + serverPort;
    }

    @GetMapping(value = "/server")
    public String getProvider() {
        return restTemplate.getForObject(serverURL + "/test", String.class);
    }
}
