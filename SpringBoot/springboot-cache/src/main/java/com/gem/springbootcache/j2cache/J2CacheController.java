/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gem.springbootcache.j2cache;

import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/j2cache")
public class J2CacheController {
    private String key = "j2cacheKey";
    private String testRegion = "testRegion";
    @Autowired
    private CacheChannel cacheChannel;

    @GetMapping("/getValue")
    public String getValue() {
        CacheObject cacheObject = cacheChannel.get(testRegion, key);
        if (cacheObject.getValue() == null) {
            // 从缓存取不到值，我们从数据库去查询
            String dbString = "数据库的值";
            // 放入缓存
            cacheChannel.set(testRegion, key, dbString);
            return dbString;
        }
        return cacheObject.getValue().toString();
    }

    @GetMapping("/getValue1")
    public String getValue1() {
        CacheObject cacheObject = cacheChannel.get(testRegion, key);
        return cacheObject.getValue().toString();
    }

    /**
     * 一级缓存和二级缓存都会清理。
     *
     * @return
     */
    @GetMapping("/evict")
    public String evict() {
        cacheChannel.evict(testRegion, key);
        return "evice success";
    }

    /**
     * 清理指定区域。
     *
     * @return
     */
    @GetMapping("/clear")
    public String clear() {
        cacheChannel.clear(testRegion);
        return "clear success";
    }

    /**
     * 判断缓存中的数据是否存在
     *
     * @return
     */
    @GetMapping("/exists")
    public String exists() {
        boolean result = cacheChannel.exists(testRegion, key);
        return "exists:" + result;
    }

    /**
     * 判断数据从哪一级获取
     *
     * @return
     */
    @GetMapping("/check")
    public String check() {
        int level = cacheChannel.check(testRegion, key);
        return "level:" + level;
    }
}