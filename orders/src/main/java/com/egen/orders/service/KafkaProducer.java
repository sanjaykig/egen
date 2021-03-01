/**
 * 
 */
package com.egen.orders.service;

import com.egen.orders.model.Order;

/**
 * @author sanjaykhan
 *
 */
public interface KafkaProducer {

	void sendMessage(Order order);
}
