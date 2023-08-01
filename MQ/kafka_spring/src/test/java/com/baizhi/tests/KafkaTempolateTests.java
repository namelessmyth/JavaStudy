package com.baizhi.tests;

import com.baizhi.KafkaSpringBootApplication;
import com.baizhi.service.IOrderService;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {KafkaSpringBootApplication.class})
@RunWith(SpringRunner.class)
public class KafkaTempolateTests {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void testSend() {
        kafkaTemplate.send(new ProducerRecord<String,String>("topic01","key1","msg-springboot-test-2"));
        System.out.println("send msg success!");
    }

    @Test
    public void testSendTransaction() {
        kafkaTemplate.executeInTransaction(new KafkaOperations.OperationsCallback() {
            @Override
            public Object doInOperations(KafkaOperations kafkaOperations) {
                return kafkaOperations.send(new ProducerRecord("topic01", "key2", "transaction001"));
            }
        });
        System.out.println("send msg success!");
    }
}
