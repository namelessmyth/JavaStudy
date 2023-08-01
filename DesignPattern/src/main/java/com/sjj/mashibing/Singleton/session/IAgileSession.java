package com.sjj.mashibing.Singleton.session;

import lombok.Data;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/31/0031
 */
public class IAgileSession {
    String username;
    String url;
    String password;

    public IAgileSession(){
        System.out.println("init session");
    }

    public Object getValue(Object key){
        return key;
    }
}
