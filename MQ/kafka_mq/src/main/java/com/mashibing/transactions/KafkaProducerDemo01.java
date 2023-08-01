package com.mashibing.transactions;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerDemo01 {
    public static void main(String[] args) {
        //1.创建链接参数
        Properties props=new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"CentOSA:9092,CentOSB:9092,CentOSC:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        props.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG,"transaction-id");

        //2.创建生产者
        KafkaProducer<String,String> producer=new KafkaProducer<String, String>(props);
        producer.initTransactions();//初始化事务

        try{
            producer.beginTransaction();//开启事务
            //3.封账消息队列
            for(Integer i=0;i< 10;i++){
                Thread.sleep(10000);
                ProducerRecord<String, String> record = new ProducerRecord<>("topic01", "key" + i, "value" + i);
                producer.send(record);
            }
            producer.commitTransaction();//提交事务
        }catch (Exception e){
            producer.abortTransaction();//终止事务
        }

        producer.close();
    }
}
