package org.apache.rocketmq.example.others;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //实例化消息生产者
        DefaultMQProducer producer = new DefaultMQProducer("producer_group_1");
        //设置nameserver的地址
        producer.setNamesrvAddr("dev-study:9876");
        //启动消息生产者
        producer.start();
        //创建消息并发送
        for (int i = 1; i <= 10; i++) {
            Message msg = new Message("TopicTest", "TagA", ("这是第" + i + "条消息").getBytes());
            SendResult result = producer.send(msg);
            System.out.println(result);
        }
        //如果不在发送消息，关闭Producer实例
        producer.shutdown();
    }
}
