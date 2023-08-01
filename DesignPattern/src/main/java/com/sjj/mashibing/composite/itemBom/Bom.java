package com.sjj.mashibing.composite.itemBom;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/4/3/0003
 */
@Data
public class Bom extends Row {
    List<Row> children;

    public Bom() {
    }

    public Bom(String itemNumber, BigDecimal qty, BigDecimal price) {
        this.itemNumber = itemNumber;
        this.qty = qty;
        this.price = price;
    }

    @Override
    public BigDecimal getPrice(){
        BigDecimal d = this.price;
        if(CollUtil.isNotEmpty(children)){
            for(Row r : children){
                BigDecimal dd = NumberUtil.mul(this.price, this.qty);
                d = d.add(dd);
            }
        }
        return d;
    }

    @Override
    public void addChild(Row r) {
        if (CollUtil.isEmpty(children)) {
            children = new ArrayList<>();
        }
        children.add(r);
    }
}
