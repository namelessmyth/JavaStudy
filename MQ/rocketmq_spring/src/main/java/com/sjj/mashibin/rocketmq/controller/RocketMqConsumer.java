package com.sjj.mashibin.rocketmq.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/7/25
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "topic-spring", consumerGroup = "consumer-spring")
public class RocketMqConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        log.info("消费者收到信息：" + message);
    }
}
