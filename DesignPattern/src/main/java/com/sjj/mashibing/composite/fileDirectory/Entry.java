package com.sjj.mashibing.composite.fileDirectory;

import lombok.ToString;

/**
 * Entry抽象类,用来定义File类和Directory类的共性内容
 **/
@ToString
public abstract class Entry {

    public abstract String getName(); //获取文件名

    public abstract int getSize(); //获取文件大小

    //添加文件夹或文件
    public abstract Entry add(Entry entry);

    //显示指定目录下的所有信息
    public abstract void printList(String prefix);

}
