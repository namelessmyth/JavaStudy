package com.mashibing.cloudalibabanacos9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaNacos9002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaNacos9002Application.class, args);
    }

}
