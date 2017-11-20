package com.atul.iot.kafka;

import com.atul.iot.kafka.entity.Payload;
import com.atul.iot.kafka.repository.PayloadRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.List;

/**
 * Created by atul on 11/20/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IOTMongoTest {
    @Autowired
    PayloadRepository payloadRepository;

//    @Test
    public void testSavePayload(){
        Calendar calendar = Calendar.getInstance();
        Payload payload = new Payload("Payload data @"+calendar.getTime(),"test");
        payloadRepository.save(payload);

    }

    @Test
    public void testGetAllPayload(){

        List<Payload> payloads = payloadRepository.findAll();
        Assert.assertNotNull(payloads);
        Assert.assertTrue(payloads.size()>0);
        payloads.forEach(payload -> System.out.println("Payload :"+payload));
    }
}
