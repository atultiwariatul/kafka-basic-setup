package com.atul.iot.kafka.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by atul on 11/20/17.
 */
@Document(collection = "payloads")
public class Payload {
    @Id
    private ObjectId id;

    @Indexed private String data;
    @Indexed private String topic;

    public Payload(String data, String topic) {
        this.data = data;
        this.topic = topic;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "data='" + data + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
