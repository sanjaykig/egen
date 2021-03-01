/**
 * 
 */
package com.egen.orders.service;

import com.egen.orders.model.Order;

/**
 * @author sanjaykhan
 *
 */
public interface KafkaProducer { // Kafka service interface for abstraction

	void sendMessage(Order order);
}
