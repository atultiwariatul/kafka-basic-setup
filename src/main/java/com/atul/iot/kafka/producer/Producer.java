package com.atul.iot.kafka.producer;

import com.atul.iot.kafka.entity.Payload;
import com.atul.iot.kafka.repository.PayloadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Calendar;

public class Producer {

  private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;
  @Autowired
  PayloadRepository payloadRepository;

  public void send(String topic, String payload) {
    LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
    String date = Calendar.getInstance().getTime().toString();
    payload = payload.concat(date);
    kafkaTemplate.send(topic, payload);
    LOGGER.debug("Sending payload completed successfully, saving data to mongo...");
    payloadRepository.save(new Payload(payload,topic));
    LOGGER.info("Saved data successfully ");
  }
}