package com.sjj.mashibing.composite.itemBom;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 抽象构建-bom结构中的任意一行。
 **/
@Data
public abstract class Row {
    String itemNumber;
    String refDesig;
    String remark;
    BigDecimal qty;
    BigDecimal price;

    void addChild(Row r){
        throw new UnsupportedOperationException();
    }
}
