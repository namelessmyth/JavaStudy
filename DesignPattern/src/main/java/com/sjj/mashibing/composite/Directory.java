package com.sjj.mashibing.composite;

import com.sjj.mashibing.composite.fileDirectory.Entry;

import java.util.ArrayList;

/**
 * Directory类，树枝节点，表示文件夹
 **/
public class Directory extends Entry{

    //文件的名字
    private String name;

    //文件夹与文件的集合
    private ArrayList<Entry> directory = new ArrayList();

    //构造函数
    public Directory(String name) {
        this.name = name;
    }

    //获取文件名称
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * 获取文件大小
     *      1.如果entry对象是File类型,则调用getSize方法获取文件大小
     *      2.如果entry对象是Directory类型,会继续调用子文件夹的getSize方法,形成递归调用.
     */
    @Override
    public int getSize() {
        int size = 0;

        //遍历或者去文件大小
        for (Entry entry : directory) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

    //显示目录
    @Override
    public void printList(String prefix) {
        System.out.println("/" + this);
        for (Entry entry : directory) {
            entry.printList("/" + name);
        }
    }
}
