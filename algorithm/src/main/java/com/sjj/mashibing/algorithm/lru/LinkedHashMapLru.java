package com.sjj.mashibing.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2024/1/5
 */
public class LinkedHashMapLru {
    public static void main(String[] args) {
        LinkedHashMap<String,String> map = new LinkedHashMap<String,String>(5,0.75F,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                //容量达到5就移除元素
                return this.size() > 4;
            }
        };

        map.put("1","aa");
        map.put("2","bb");
        map.put("3","cc");
        map.put("4","dd");
        System.out.println("原始值："+Objects.toString(map));

        map.get("2");
        System.out.println("2 读取之后："+Objects.toString(map));

        map.get("3");
        System.out.println("3 读取之后："+Objects.toString(map));

        map.put("5","ee");
        System.out.println("5 加入之后："+Objects.toString(map));
    }
}
