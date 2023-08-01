package com.sjj.mashibing.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayLoadBalance9999Application {

    public static void main(String[] args) {
        SpringApplication.run(GatewayLoadBalance9999Application.class, args);
    }

}
