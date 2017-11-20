package com.atul.iot.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class IotKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotKafkaApplication.class, args);
	}
}
