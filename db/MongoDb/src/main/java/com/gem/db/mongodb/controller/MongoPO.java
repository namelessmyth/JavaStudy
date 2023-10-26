package com.gem.db.mongodb.controller;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/10/26
 */
@Document("collection1")
@Data
@ToString
public class MongoPO {
    private String id;
    private Integer a;
    private Integer b;
    private String s;
}
