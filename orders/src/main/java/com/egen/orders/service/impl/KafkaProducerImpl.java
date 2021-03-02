/**
 * 
 */
package com.egen.orders.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.egen.orders.model.Order;
import com.egen.orders.service.KafkaProducer;

/**
 * @author sanjaykhan
 *
 */
@Service
public class KafkaProducerImpl implements KafkaProducer{ // Implementation of Kafka Producer

	//Dependency Injection
	@Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;
	
    private static final String TOPIC = "order";
    
	private final Logger log = LogManager.getLogger(this.getClass()); // Log4J
	
	@Override
	public void sendMessage(Order order) {
		
		log.info(String.format("@@@@ : Producing message to topic %s -> %s", TOPIC,order));
        this.kafkaTemplate.send(TOPIC, order);
		// TODO Auto-generated method stub
		
	}

}
