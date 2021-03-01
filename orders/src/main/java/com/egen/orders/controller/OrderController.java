/**
 * 
 */
package com.egen.orders.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egen.orders.dto.OrderDTO;
import com.egen.orders.enums.Errors;
import com.egen.orders.enums.Status;
import com.egen.orders.exception.ResourceNotFoundException;
import com.egen.orders.model.Order;
import com.egen.orders.model.OrderAddress;
import com.egen.orders.service.KafkaProducer;
import com.egen.orders.service.OrderService;

import io.swagger.annotations.ApiOperation;

/**
 * @author sanjaykhan
 *
 */
@RestController
@RequestMapping("/order/")
public class OrderController { // Controller class for order API

	// Dependency Injection
	
	@Autowired
    KafkaProducer kafkaProducer;
	
	@Autowired
	private OrderService orderService;
	
	private final Logger log = LogManager.getLogger(this.getClass()); // Log4J
	
	
	// API Request Mappings
	
	@GetMapping(value = "/order/{id}") // get order by ID
    @ApiOperation(value = "Get order by id",response = Order.class)
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long orderId) throws ResourceNotFoundException{
		log.info("Fetching the order details with id: "+ String.valueOf(orderId));
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
	
	@PostMapping(value = "/order") // Create new order
    @ApiOperation(value = "Create a new order", response = Order.class)
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO){
        log.info("Starting a new Order");

        Order order = new Order();
        List<OrderAddress> addressList = new ArrayList<>();

        if(orderDTO != null) {
            OrderAddress billingAddress = orderDTO.getBillingAddress();
            OrderAddress shipAddress = orderDTO.getShippingAddress();
            billingAddress.setType("Billing");
            shipAddress.setType("Shipping");
            order.setOrderStatus(Status.STARTED.getStatus());
            order.setSubTotal(orderDTO.getSub_total());
            order.setTax(orderDTO.getTax());
            order.setTotal(orderDTO.getTotal());
            order.setCustomerId(21L);
            order.setOrderDetails(orderDTO.getOrderDetailList());
            addressList.add(billingAddress);
            addressList.add(shipAddress);
            order.setAddressesList(addressList);
            order.setOrderPaymentList(orderDTO.getPayment_details());
            log.info("Created the new Order");
            return ResponseEntity.ok(orderService.createOrder(order));
        } else {
            return new ResponseEntity<>(Errors.JSON_NOT_FORMED,HttpStatus.BAD_REQUEST);
        }

    }
	
	@PatchMapping(value = "/order/cancel/{id}")
    @ApiOperation(value = "Cancel order by order id",response = Order.class)
    public ResponseEntity<Order> cancelOrder(@PathVariable("id") Long id){
		log.info("Cancelling the order id : "+ String.valueOf(id));
        try {
			return ResponseEntity.ok(orderService.cancelOrder(id));
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
    }
	
	
    @PostMapping(value = "/bulk/order")
    @ApiOperation(value = "Create bulk orders using async call",response = Order.class)
    public ResponseEntity<Order> createBulkOrder(@RequestBody List<OrderDTO> orderList){

        for(OrderDTO orderDTO: orderList) {
            Order order = new Order();
            List<OrderAddress> addressList = new ArrayList<>();
            OrderAddress billingAddress = orderDTO.getBillingAddress();
            OrderAddress shipAddress = orderDTO.getShippingAddress();

            billingAddress.setType("Billing");
            shipAddress.setType("Shipping");
            order.setOrderStatus(Status.STARTED.getStatus());
            order.setSubTotal(orderDTO.getSub_total());
            order.setTax(orderDTO.getTax());
            order.setTotal(orderDTO.getTotal());
            order.setCustomerId(21L);
            order.setOrderDetails(orderDTO.getOrderDetailList());
            addressList.add(billingAddress);
            addressList.add(shipAddress);
            order.setAddressesList(addressList);
            order.setOrderPaymentList(orderDTO.getPayment_details());
            kafkaProducer.sendMessage(order);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/bulk/order/update")
    @ApiOperation(value = "update orders in bulk",response = Order.class)
    public ResponseEntity<Order> updateOrders(@RequestBody List<Order> orderList){
    	log.info("Starting bulk update");
        for(Order order:orderList) kafkaProducer.sendMessage(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
