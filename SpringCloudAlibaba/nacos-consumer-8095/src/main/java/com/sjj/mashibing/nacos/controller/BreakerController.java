package com.sjj.mashibing.nacos.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sjj.mashibing.entity.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/4/18/0018
 */
@RestController
@Slf4j
public class BreakerController {
    //服务提供者URL
    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value="fallback", fallback = "fallbackHandler")
    public JsonResult<String> fallback(@PathVariable Long id){
        if(id > 3L){
            throw new NullPointerException("没有找到对应的数据！");
        }
        //通过Ribbon发起远程访问，访问9003/9004
        JsonResult<String> result = restTemplate.getForObject(SERVICE_URL+"/info/"+id,JsonResult.class);
        return result;
    }

    //保证方法签名基本保持一致，但是要添加异常类型参数
    public JsonResult<String> fallbackHandler(Long id,Throwable e){
        JsonResult<String> result = new JsonResult<>(500,"8095","出现未知商品id");
        return result;
    }
}
