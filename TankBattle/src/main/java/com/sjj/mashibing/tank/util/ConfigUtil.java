package com.sjj.mashibing.tank.util;

import cn.hutool.setting.dialect.Props;

import java.math.BigDecimal;

/**
 * 配置文件-公共类<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/8
 */
public class ConfigUtil {
    private static Props prop;

    public static void initProp(){
        if(prop == null){
            prop = new Props("config-tank.properties");
        }
    }

    public static Object getObj(String key, Object defaultValue) {
        initProp();
        return prop.getObj(key, defaultValue);
    }

    public static Object getObj(String key) {
        initProp();
        return prop.getObj(key);
    }

    public static String getStr(String key, String defaultValue) {
        initProp();
        return prop.getStr(key, defaultValue);
    }

    public static String getStr(String key) {
        initProp();
        return prop.getStr(key);
    }

    public static Integer getInt(String key, Integer defaultValue) {
        initProp();
        return prop.getInt(key, defaultValue);
    }

    public static Integer getInt(String key) {
        initProp();
        return prop.getInt(key);
    }

    public static Boolean getBool(String key, Boolean defaultValue) {
        initProp();
        return prop.getBool(key, defaultValue);
    }

    public static Boolean getBool(String key) {
        initProp();
        return prop.getBool(key);
    }

    public static Double getDouble(String key, Double defaultValue) throws NumberFormatException {
        initProp();
        return prop.getDouble(key, defaultValue);
    }

    public static Double getDouble(String key) throws NumberFormatException {
        initProp();
        return prop.getDouble(key);
    }

    public static BigDecimal getBigDecimal(String key, BigDecimal defaultValue) {
        initProp();
        return prop.getBigDecimal(key, defaultValue);
    }

    public static BigDecimal getBigDecimal(String key) {
        initProp();
        return prop.getBigDecimal(key);
    }
}
