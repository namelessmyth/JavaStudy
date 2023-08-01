package org.apache.rocketmq.example.scheduled;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * 延时消息-生产者
 */
public class ScheduledMessageProducer {
    public static void main(String[] args) throws Exception {
        // 实例化一个生产者来产生延时消息
        DefaultMQProducer producer = new DefaultMQProducer("ScheduledProducer");
        // 设置NameServer的地址
        producer.setNamesrvAddr("dev-study:9876");
        // 启动Producer实例
        producer.start();
        int totalMessagesToSend = 10;
        for (int i = 0; i < totalMessagesToSend; i++) {
            Message message = new Message("ScheduledTopic", ("Hello scheduled message " + i).getBytes());
            // 设置延时等级3,这个消息将在10s之后投递给消费者(详看delayTimeLevel)
            message.setDelayTimeLevel(3);
            // 发送消息
            producer.send(message);
        }
        // 关闭生产者
        producer.shutdown();
    }
}
