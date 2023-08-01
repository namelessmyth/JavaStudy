package com.mashibing.serializer;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class ObjectDeserializer implements Deserializer<Object> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        System.out.println("configure");
    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        return SerializationUtils.deserialize(data);
    }

    @Override
    public void close() {
        System.out.println("close");
    }
}
