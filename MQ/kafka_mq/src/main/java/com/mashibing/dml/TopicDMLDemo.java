package com.mashibing.dml;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Slf4j
public class TopicDMLDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //配置连接参数，这里面出现的主机名，需要在hosts文件中配置好ip映射
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
                "dev-study:9092");
        //创建与kafka服务器的客户端连接（注意关闭linux防火墙）
        KafkaAdminClient adminClient = (KafkaAdminClient) KafkaAdminClient.create(props);

        //查询所有的topics
        KafkaFuture<Set<String>> nameFutures = adminClient.listTopics().names();
        for (String name : nameFutures.get()) {
            log.info("topic-name:{}", name);
        }

        //创建Topics
        List<NewTopic> newTopics = Arrays.asList(new NewTopic("topic02", 3, (short) 1));

        //删除Topic
        // adminClient.deleteTopics(Arrays.asList("topic02"));

        //查看Topic详情
        DescribeTopicsResult describeTopics = adminClient.describeTopics(Arrays.asList("topic01"));
        Map<String, TopicDescription> tdm = describeTopics.all().get();
        for (Map.Entry<String, TopicDescription> entry : tdm.entrySet()) {
            log.info(entry.getKey() + "\t" + entry.getValue());
        }

        adminClient.close();
    }
}
