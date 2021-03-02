/**
 * 
 */
package com.egen.orders.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.egen.orders.model.Order;
import com.egen.orders.service.KafkaConsumer;
import com.egen.orders.service.OrderService;

/**
 * @author sanjaykhan
 *
 */
@Service
public class KafkaConsumerImpl implements KafkaConsumer { // Implementation of Kafka Consumer

	@Autowired
    OrderService orderService;

	private final Logger log = LogManager.getLogger(this.getClass()); // Log4J

    @KafkaListener(topics = "order", groupId = "group_id",containerFactory="orderKafkaListenerContainerFactory")
    
    @Override
    public void consume(Order order)  {
        log.info(String.format("@@@@ : Consuming Kafka message -> %s", order));
        if(orderService.isOrderExists(order.getOrderId())){
            orderService.updateOrder(order);
        } else {
            orderService.createOrder(order);
        }
    }
}
