package com.sjj.mashibing.nacos.service;

import com.sjj.mashibing.entity.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * OpenFeign的接口，
 * 在此接口中添加@FeignClient接口同时标注要调用的服务端名称，
 * 同时使用与服务提供者方法签名一致的抽象方法来表示远程调用的
 */
@Service
@FeignClient("nacos-provider")
public interface OpenFeignService {

    @GetMapping("info/{id}")
    public JsonResult<String> msbSql(@PathVariable("id") Long id);
}
