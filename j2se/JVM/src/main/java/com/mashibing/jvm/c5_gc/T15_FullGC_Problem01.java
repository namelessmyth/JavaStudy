package com.mashibing.jvm.c5_gc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 一个银行经理在决定贷款给一个人的时候，由于担心这个人可能不还钱，所以会做风险控制。
 * 具体办法就是从各种数据库中读取这个人的相关信用数据，经过分析后套用风险模型，并把风险评估结果进行记录和传输
 */
public class T15_FullGC_Problem01 {
    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(50,
            new ThreadPoolExecutor.DiscardOldestPolicy());

    /**
     * 模拟信用卡记录
     */
    private static class CardInfo {
        BigDecimal price = new BigDecimal(0.0);
        String name = "张三";
        int age = 5;
        Date birthdate = new Date();

        public void m() {
        }
    }

    public static void main(String[] args) throws Exception {
        executor.setMaximumPoolSize(50);
        for (; ; ) {
            //不停的循环，逐渐耗尽内存。
            modelFit();
            Thread.sleep(100);
        }
    }

    /**
     * 使用信用卡记录，匹配风险模型。
     */
    private static void modelFit() {
        List<CardInfo> taskList = getAllCardInfo();
        taskList.forEach(info -> {
            executor.scheduleWithFixedDelay(() -> {
                info.m();
            }, 2, 3, TimeUnit.SECONDS);
        });
    }

    /**
     * 模拟从数据库中读取信用卡记录，每次读取100条记录。
     */
    private static List<CardInfo> getAllCardInfo() {
        List<CardInfo> taskList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            CardInfo ci = new CardInfo();
            taskList.add(ci);
        }

        return taskList;
    }
}
