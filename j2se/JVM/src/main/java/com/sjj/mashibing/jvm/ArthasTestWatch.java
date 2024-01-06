package com.sjj.mashibing.jvm;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/6/6/0006
 */
public class ArthasTestWatch {
    public static int a(int i) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        i++;
        return b(i);
    }

    public static int b(int i) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        i--;
        System.out.println("b：" + i);
        return c(i);
    }

    public static int c(int i) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        i = i * i;
        System.out.println("c：" + i);
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("请输入一个整数！");
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int i = s.nextInt();
            System.out.println("用户输入了：" + i);
            a(i);
            System.out.println("计算完毕，请再次输入！");
        }
    }
}
