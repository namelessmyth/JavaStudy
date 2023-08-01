package com.sjj.mashibing.Singleton.session;

import com.sjj.mashibing.Singleton.SingletonLasy;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 单例模式-反射破坏<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/17
 */
public class ISessionUtilDestroy {
    /**
     * 序列化破坏
     * @throws Exception
     */
    public static void serializable() throws Exception {
        //序列化对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile.obj"));
        oos.writeObject(ISessionUtil.session.getAdmin());

        //序列化对象输入流
        File file = new File("tempFile.obj");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        IAgileSession Singleton = (IAgileSession) ois.readObject();

        //判断是否是同一个对象
        System.out.println("是否同一个实例：" + (ISessionUtil.session.getAdmin() == Singleton));//false
    }

    /**
     * 反射破坏
     * @throws Exception
     */
    public static void reflection() throws Exception {
        Constructor c = SingletonLasy.class.getDeclaredConstructor(null);

        //设置为true,就可以对类中的私有成员进行操作了
        c.setAccessible(true);

        Object instance1 = c.newInstance();
        Object instance2 = c.newInstance();

        System.out.println("是否同一个实例：" + (instance1 == instance2));
    }

    public static void main(String[] args) throws Exception {
        serializable();
        reflection();
    }
}
