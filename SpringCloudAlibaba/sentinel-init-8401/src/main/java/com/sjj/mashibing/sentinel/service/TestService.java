package com.sjj.mashibing.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    // 定义限流资源
    @SentinelResource("common")
    public String common(){
        return "common";
    }
}
