package com.sjj.mashibin.rocketmq.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/7/25
 */
@Slf4j
@RestController
@RequestMapping("/mq")
public class ProducerController {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;//注入Mq
    private String TOPIC = "topic-spring";

    /**
     * 默认发送方法，无返回值
     *
     * @param content 消息内容
     * @return
     */
    @RequestMapping(value = "/convertAndSend", method = RequestMethod.GET)
    public String convertAndSend(String content) {
        rocketMQTemplate.convertAndSend(TOPIC, "message payload:" + content);
        return "发送成功";
    }

    /**
     * 同步发送，有返回值
     * @param content 消息内容
     * @return
     */
    @RequestMapping(value = "/syncSend", method = RequestMethod.GET)
    public String syncSend(String content) {
        SendResult result = rocketMQTemplate.syncSend(TOPIC, "message payload:" + content);
        return "发送成功:" + result;
    }

    /**
     * 异步发送，有返回值
     * @param content 消息内容
     * @return
     */
    @RequestMapping(value = "/asyncSend", method = RequestMethod.GET)
    public String asyncSend(String content) {
        //添加信息
        rocketMQTemplate.asyncSend(TOPIC, content, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("异步消息发送成功:{}", sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                log.error("异步消息发送异常:{}", throwable);
            }
        });
        return "添加成功";
    }

    /**
     * 有序发送
     * @param content
     */
    @RequestMapping("sendSelector")
    public void sendSelector(String content) {
        rocketMQTemplate.setMessageQueueSelector(new MessageQueueSelector() {
            @Override
            public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                //可以自定义规则，取list的第几个，这里取第一个
                return list.get(1);
            }
        });
        rocketMQTemplate.syncSendOrderly(TOPIC, MessageBuilder.withPayload("Selector:" + content).build(),"key");
    }

    /**
     * 延迟消息
     * @param content
     */
    @RequestMapping("sendDelay")
    public void sendDelay(String content) {
        rocketMQTemplate.syncSend(TOPIC, MessageBuilder.withPayload("Delay:" + content).build(), 3000, 2);
    }
}
