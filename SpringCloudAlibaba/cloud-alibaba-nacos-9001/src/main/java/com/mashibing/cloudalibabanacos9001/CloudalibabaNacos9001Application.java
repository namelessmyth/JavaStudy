package com.mashibing.cloudalibabanacos9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaNacos9001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaNacos9001Application.class, args);
    }

}
