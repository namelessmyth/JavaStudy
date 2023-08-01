package com.sjj.mashibing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 公共返回值<br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JsonResult<T> {
    private Integer code;
    private String serverPort;
    private T data;
}
