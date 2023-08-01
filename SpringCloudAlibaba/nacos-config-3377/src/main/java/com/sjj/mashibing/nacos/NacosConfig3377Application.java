package com.sjj.mashibing.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/2/6
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfig3377Application {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfig3377Application.class, args);
    }
}
