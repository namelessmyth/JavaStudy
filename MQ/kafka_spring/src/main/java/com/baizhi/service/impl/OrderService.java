package com.baizhi.service.impl;

import com.baizhi.service.IOrderService;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单Service
 */
@Transactional
@Service
public class OrderService implements IOrderService {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public void saveOrder(String id, Object message) {
        kafkaTemplate.send(new ProducerRecord("topic01", id, message));
    }
}
