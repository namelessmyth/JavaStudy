package com.mashibing.acks;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerDemo_02 {
    public static void main(String[] args) {
        //1.创建链接参数
        Properties props=new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"CentOSA:9092,CentOSB:9092,CentOSC:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,UserDefineProducerInterceptor.class.getName());
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,1);
        props.put(ProducerConfig.ACKS_CONFIG,"-1");
        props.put(ProducerConfig.RETRIES_CONFIG,3);
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,true);

        //2.创建生产者
        KafkaProducer<String,String> producer=new KafkaProducer<String, String>(props);

        //3.封账消息队列
        for(Integer i=0;i< 1;i++){
            ProducerRecord<String, String> record = new ProducerRecord<>("topic01", "key" + i, "value" + i);
            producer.send(record);
        }

        producer.close();
    }
}
