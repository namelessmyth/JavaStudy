package com.sjj.mashibing.observer.jdk;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/4/3/0003
 */
public class Test {
    public static void main(String[] args) {
        //来了一个小丑
        Clown clown = new Clown();
        //观众入场了
        for (int i = 0; i < 5; i++) {
            Viewer v = new Viewer(i);
            clown.addObserver(v);
            System.out.println("座号为" + v.getSeatNo() + "的观众入座");
        }
        //小丑开始表演
        clown.perform();
        //小丑表演完毕，退场
        clown.exit();
    }
}
