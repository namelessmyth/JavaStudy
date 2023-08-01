package com.mashibing.jvm.c2_classloader;

import com.mashibing.jvm.c5_gc.T15_FullGC_Problem01;

public class T003_ClassLoaderScope {
    /**
     * 通过这些代码打印每个类加载实际的负责加载的范围
     */
    public static void main(String[] args) {
        String pathBoot = System.getProperty("sun.boot.class.path");
        System.out.println("sun.boot.class.path--------------------");
        System.out.println(pathBoot.replaceAll(";", System.lineSeparator()));

        System.out.println("java.ext.dirs--------------------");
        String pathExt = System.getProperty("java.ext.dirs");
        System.out.println(pathExt.replaceAll(";", System.lineSeparator()));

        System.out.println("java.class.path--------------------");
        String pathApp = System.getProperty("java.class.path");
        System.out.println(pathApp.replaceAll(";", System.lineSeparator()));
    }
}
