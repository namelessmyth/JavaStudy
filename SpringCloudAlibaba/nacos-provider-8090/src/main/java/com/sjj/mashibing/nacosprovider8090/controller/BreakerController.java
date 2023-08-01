package com.sjj.mashibing.nacosprovider8090.controller;

import com.sjj.mashibing.entity.JsonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * sentinel服务熔断测试类<br>
 */
@RestController
public class BreakerController {
    @Value("${server.port}")
    private String serverPort;

    //模仿数据库存储数据
    public static HashMap<Long, String> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, "鼠标");
        hashMap.put(2L, "键盘");
        hashMap.put(3L, "耳机");
    }

    @GetMapping("info/{id}")
    public JsonResult<String> msbSql(@PathVariable("id") Long id) {
        JsonResult<String> result = new JsonResult(200, serverPort, hashMap.get(id));
        return result;
    }
}
