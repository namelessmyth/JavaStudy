package com.sjj.mashibing.nacosprovider8090;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//加此注解
public class NacosProvider8090Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvider8090Application.class, args);
    }

}
