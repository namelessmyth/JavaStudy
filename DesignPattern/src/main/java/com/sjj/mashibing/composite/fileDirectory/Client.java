package com.sjj.mashibing.composite.fileDirectory;

import com.sjj.mashibing.composite.Directory;
import com.sjj.mashibing.composite.fileDirectory.Entry;
import com.sjj.mashibing.composite.fileDirectory.File;

public class Client {

    public static void main(String[] args) {
        //根节点
        Entry rootDir = new Directory("root");
        //树枝节点
        Entry binDir = new Directory("bin");
        //向bin目录中添加叶子节点
        binDir.add(new File("vi",10000));
        binDir.add(new File("test",20000));

        Entry tmpDir = new Directory("tmp");
        Entry usrDir = new Directory("usr");
        Entry mysqlDir = new Directory("mysql");
        mysqlDir.add(new File("my.cnf",30));
        mysqlDir.add(new File("test.db",25000));
        usrDir.add(mysqlDir);

        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(mysqlDir);

        rootDir.printList("");
    }
}
