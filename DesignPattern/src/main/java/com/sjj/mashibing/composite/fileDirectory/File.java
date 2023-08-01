package com.sjj.mashibing.composite.fileDirectory;

/**
 * File类 表示文件
 **/
public class File extends Entry {

    private String name; //文件名
    private int size; //文件大小

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Entry add(Entry entry) {
        return null;
    }

    @Override
    public void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}