package com.atul.iot.kafka.repository;

import com.atul.iot.kafka.entity.Payload;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by atul on 11/20/17.
 */
public interface PayloadRepository extends MongoRepository<Payload,String>{

}
