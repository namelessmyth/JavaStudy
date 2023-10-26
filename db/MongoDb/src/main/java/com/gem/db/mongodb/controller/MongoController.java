package com.gem.db.mongodb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/10/26
 */
@RestController
@RequestMapping("/mongo")
@Slf4j
public class MongoController {
    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/insertOne")
    public String insertOne() {
        MongoPO p = new MongoPO();
        p.setA(3);
        p.setB(3);
        mongoTemplate.insert(p);
        return p.toString();
    }
}
