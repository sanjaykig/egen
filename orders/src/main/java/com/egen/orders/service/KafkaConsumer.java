/**
 * 
 */
package com.egen.orders.service;

import com.egen.orders.model.Order;

/**
 * @author sanjaykhan
 *
 */
public interface KafkaConsumer { // Kafka service interface for abstraction
	
	void consume(Order order);
}
