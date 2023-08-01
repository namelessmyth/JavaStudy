package com.mashibing.serializer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Pattern;

public class KafkaConsumerDemo {
    public static void main(String[] args) {
        //1.创建Kafka链接参数
        Properties props=new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"CentOSA:9092,CentOSB:9092,CentOSC:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,ObjectDeserializer.class.getName());
        props.put(ConsumerConfig.GROUP_ID_CONFIG,"group01");

        //2.创建Topic消费者
        KafkaConsumer<String,User> consumer=new KafkaConsumer<String, User>(props);
        //3.订阅topic开头的消息队列
        consumer.subscribe(Pattern.compile("^topic.*$"));

        while (true){
            ConsumerRecords<String, User> consumerRecords = consumer.poll(Duration.ofSeconds(1));
            Iterator<ConsumerRecord<String, User>> recordIterator = consumerRecords.iterator();
            while (recordIterator.hasNext()){
                ConsumerRecord<String, User> record = recordIterator.next();
                String key = record.key();
                User value = record.value();
                long offset = record.offset();
                int partition = record.partition();
                System.out.println("key:"+key+",value:"+value+",partition:"+partition+",offset:"+offset);
            }
        }
    }
}
