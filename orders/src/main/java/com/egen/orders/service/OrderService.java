/**
 * 
 */
package com.egen.orders.service;

import java.util.List;

import com.egen.orders.exception.ResourceNotFoundException;
import com.egen.orders.model.Order;

/**
 * @author sanjaykhan
 *
 */

public interface OrderService {
	
	Order getOrderById(Long orderId) throws ResourceNotFoundException;
	
    boolean isOrderExists(Long orderId);
    
    Order createOrder(Order order);
    
    Order completeOrder(Long orderId);
    
    Order cancelOrder(Long orderId);
    
    Order updateOrder(Order order);
    
    void saveBulkOrder(List<Order> orderList);
}
