package com.sjj.mashibing.jvm;

import cn.hutool.core.util.ObjectUtil;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.lang.instrument.Instrumentation;
import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/7/28
 */
public class ObjectSize {
    public static void main(String[] args) {
        System.out.println(ObjectSizeCalculator.getObjectSize("123"));
        System.out.println(ObjectSizeCalculator.getObjectSize(123));
        System.out.println(ObjectSizeCalculator.getObjectSize(123.0));
        System.out.println(ObjectSizeCalculator.getObjectSize(123L));
        System.out.println(ObjectSizeCalculator.getObjectSize(new BigDecimal(123)));
    }
}
