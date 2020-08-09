package com.example.activeMQ;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jms.Destination;


@SpringBootTest
class ActiveMqApplicationTests {

	@Autowired
	private Producer producer;

	@Test
	void contextLoads() {
		Destination destination=new ActiveMQQueue("mytest.queue");

		for(int i=0;i<100;i++){
			producer.sendMessage(destination,"message: "+(i+1));
		}
	}

}
