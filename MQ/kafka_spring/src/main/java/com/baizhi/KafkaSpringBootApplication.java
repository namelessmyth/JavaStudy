package com.baizhi;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.messaging.handler.annotation.SendTo;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;


@SpringBootApplication
//@EnableKafkaStreams
//@EnableKafka
public class KafkaSpringBootApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(KafkaSpringBootApplication.class, args);
        System.in.read();
    }

    /**
     * kafka消费者配置，监听主题
     */
    @KafkaListeners(value = {@KafkaListener(topics = {"topic01"})})
    //@SendTo(value = {"topic01"})
    public void listener(ConsumerRecord<?, ?> cr) {
        System.out.println("ConsumerRecord: " + cr);
    }

    /**
     * 接收topic02，转发给topic03
     */
    @KafkaListeners(value = {@KafkaListener(topics = {"topic02"})})
    @SendTo(value = {"topic03"})
    public String listener02(ConsumerRecord<?, ?> cr) {
        System.out.println("ConsumerRecord: " + cr);
        return cr.value() + " mashibing edu";
    }

    //@Bean
    public KStream<String, String> kStream(StreamsBuilder kStreamBuilder) {

        KStream<String, String> stream = kStreamBuilder.stream(
                "topic02",
                Consumed.with(Serdes.String(),
                        Serdes.String()));

        stream.flatMapValues(new ValueMapper<String, Iterable<String>>() {
                    @Override
                    public Iterable<String> apply(String s) {
                        return Arrays.stream(s.split(" ")).collect(Collectors.toList());
                    }
                })
                .selectKey((k, v) -> v)
                .groupByKey(Grouped.with(Serdes.String(), Serdes.String()))
                .count(Materialized.<String, Long, KeyValueStore<Bytes, byte[]>>as("wordcount"))
                .toStream()
                .print(Printed.toSysOut());
        return stream;
    }
}
