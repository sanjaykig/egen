/**
 * 
 */
package com.egen.orders.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.orders.enums.Errors;
import com.egen.orders.enums.Status;
import com.egen.orders.exception.ResourceNotFoundException;
import com.egen.orders.model.Order;
import com.egen.orders.model.OrderAddress;
import com.egen.orders.model.OrderInfo;
import com.egen.orders.model.OrderPayment;
import com.egen.orders.repository.AddressRepository;
import com.egen.orders.repository.OrderInfoRepository;
import com.egen.orders.repository.OrderPaymentRepository;
import com.egen.orders.repository.OrderRepository;
import com.egen.orders.service.OrderService;

/**
 * @author sanjaykhan
 *
 */
@Service
public class OrderServiceImpl implements OrderService{ // Implementation Class for services

	// Dependency Injection
	@Autowired
    OrderRepository orderRepository;
	
	@Autowired
    AddressRepository addressRepository;
	
	@Autowired
    OrderPaymentRepository orderPaymentRepository;
	
	@Autowired
    OrderInfoRepository orderInfoRepository;
	
	private final Logger log = LogManager.getLogger(this.getClass()); // Log4J
	
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
		return orderRepository.existsByOrderId(orderId);
	}

	@Override
	public Order createOrder(Order order) {
		log.info("Trying to create new Order");
        try {
        	orderRepository.save(order);
        }catch(Exception e) {
        	log.error(e.getMessage());
        }
        
        Order orderObj = orderRepository.findByOrderId(order.getOrderId());

        ArrayList<OrderAddress> addressArrayList=new ArrayList<> (order.getAddressesList());
        ArrayList<OrderPayment> orderPaymentArrayList=new ArrayList<> (order.getOrderPaymentList());
        ArrayList<OrderInfo> ord= new ArrayList<> (order.getOrderDetails());

        for (OrderAddress address : addressArrayList) {
        	address.setOrder(order);
            addressRepository.saveAndFlush(address);
        }

        for (OrderPayment pay : orderPaymentArrayList){
            pay.setOrder(order);
            orderPaymentRepository.saveAndFlush(pay);
        }

        for(OrderInfo info : ord){
            info.setOrder(order);
            orderInfoRepository.saveAndFlush(info);
        }
        log.info("Order created successfully");
        return orderObj;
	}

	@Override
	public Order completeOrder(Long orderId) throws ResourceNotFoundException {
		Order order = orderRepository.findByOrderId(orderId);
        if(!order.getOrderStatus().equals(Status.STARTED.getStatus())) {
            throw new ResourceNotFoundException(Errors.ORDER_STATUS_NOT_STARTED);
        }
        order.setOrderStatus(Status.COMPLETED.getStatus());
        orderRepository.save(order);
        return orderRepository.findByOrderId(orderId);
		// TODO Auto-generated method stub
	}

	@Override
	public Order cancelOrder(Long orderId) throws ResourceNotFoundException {
		Order order = orderRepository.findByOrderId(orderId);
        if(!order.getOrderStatus().equals(Status.STARTED.getStatus())) {
            throw new ResourceNotFoundException(Errors.ORDER_STATUS_NOT_STARTED);
        }
        order.setOrderStatus(Status.CANCELLED.getStatus());
        orderRepository.save(order);
        return orderRepository.findByOrderId(orderId);
		// TODO Auto-generated method stub
	}

	@Override
	public Order updateOrder(Order order) {
		Order orderObj = orderRepository.findByOrderId(order.getOrderId());
        if(orderObj != null){
        	orderObj.setOrderDetails(order.getOrderDetails());
        	orderObj.setTotal(order.getTotal());
        	orderObj.setTax(order.getTax());
        	orderObj.setOrderPaymentList(order.getOrderPaymentList());
        	orderObj.setSubTotal(order.getSubTotal());
        	orderObj.setAddressesList(order.getAddressesList());
            return orderRepository.save(orderObj);
        }
        return null;
		// TODO Auto-generated method stub
	}

	@Override
	public void saveBulkOrder(List<Order> orderList) {
		for(Order order:orderList){
            createOrder(order);
        }
		// TODO Auto-generated method stub
		
	}

}
