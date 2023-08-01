package com.mashibing.acks;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class UserDefineProducerInterceptor implements ProducerInterceptor {
    @Override
    public ProducerRecord onSend(ProducerRecord record) {
        ProducerRecord wrapRecord = new ProducerRecord(record.topic(), record.key(), record.value());
        wrapRecord.headers().add("user","mashibing".getBytes());
        return wrapRecord;

    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        System.out.println("metadata:"+metadata+",exception:"+exception);
    }

    @Override
    public void close() {
        System.out.println("close");
    }

    @Override
    public void configure(Map<String, ?> configs) {
        System.out.println("configure");
    }
}
