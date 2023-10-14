package com.gem.springboot.thread.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/10/14
 */
@Service
@Slf4j
public class AsyncService {
    @Async("taskExecutor")
    public void task1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1L);
        log.info("task1 complete");
    }


    @Async("taskExecutor")
    public void task2() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2L);
        log.info("task2 complete");
    }

    @Async("taskExecutor")
    public void task3() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3L);
        log.info("task3 complete");
    }
}
