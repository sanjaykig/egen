/**
 * 
 */
package com.egen.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egen.orders.exception.ResourceNotFoundException;
import com.egen.orders.model.Order;
import com.egen.orders.repository.OrderRepository;
import com.egen.orders.service.OrderService;

import io.swagger.annotations.ApiOperation;

/**
 * @author sanjaykhan
 *
 */
@RestController
@RequestMapping("/order/")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/order/{id}")
    @ApiOperation(value = "Get order by id",response = Order.class)
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long orderId) throws ResourceNotFoundException{
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
}
