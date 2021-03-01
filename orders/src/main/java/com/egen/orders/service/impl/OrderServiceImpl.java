/**
 * 
 */
package com.egen.orders.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.egen.orders.enums.Errors;
import com.egen.orders.exception.ResourceNotFoundException;
import com.egen.orders.model.Order;
import com.egen.orders.repository.OrderRepository;
import com.egen.orders.service.OrderService;

/**
 * @author sanjaykhan
 *
 */
public class OrderServiceImpl implements OrderService{

	@Autowired
    OrderRepository orderRepository;
	
	@Override
	public Order getOrderById(Long orderId) throws ResourceNotFoundException {
		Order orderMain = orderRepository.findByOrderId(orderId);
        if(orderMain == null) {
            throw new ResourceNotFoundException(Errors.ORDER_NOT_FOUND);
        }
        
        return orderMain;
	}

	@Override
	public boolean isOrderExists(Long orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order completeOrder(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order cancelOrder(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveBulkOrder(List<Order> orderList) {
		// TODO Auto-generated method stub
		
	}

}
