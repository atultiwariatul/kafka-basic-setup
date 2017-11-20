package com.atul.iot.kafka;

import com.atul.iot.kafka.consumer.Consumer;
import com.atul.iot.kafka.producer.Producer;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IotKafkaApplicationTests {

	protected final static String TOPIC = "iotlabs.t";

	@Autowired
	private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

	@Autowired
	private Consumer receiver;

	@Autowired
	private Producer producer;

	@ClassRule
	public static KafkaEmbedded kafkaEmbedded = new KafkaEmbedded(1, true, TOPIC);

	@Test
	public void testReceive() throws Exception {
		producer.send(TOPIC, "This is IOT Labs message @!");
		//Wait so that we can see the Receive message as well.
		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	}
}
