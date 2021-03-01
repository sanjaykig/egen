/**
 * 
 */
package com.egen.orders.service;

import com.egen.orders.model.Order;

/**
 * @author sanjaykhan
 *
 */
public interface KafkaConsumer {
	
	void consume(Order order);
}
