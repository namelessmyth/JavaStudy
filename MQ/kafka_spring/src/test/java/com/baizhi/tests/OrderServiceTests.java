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
public class OrderServiceTests {
    @Autowired
    private IOrderService orderService;

    @Test
    public void testOrderService() {
        orderService.saveOrder("order", "订单JSON：{}");
    }
}
