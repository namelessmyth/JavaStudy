package com.gem.db.mongodb.controller;

import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/10/26
 */
@Document("c1")
@TypeAlias("mongoTestClass")
@Data
public class MonTest {
    private String nickname;
    private String userid;
    private Integer visits;
    private String content;
    private String _id;

    public MonTest(String nickname, String userid, Integer visits, String content, String _id) {
        this.nickname = nickname;
        this.userid = userid;
        this.visits = visits;
        this.content = content;
        this._id = _id;
    }
}
