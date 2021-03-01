/**
 * 
 */
package com.egen.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping(value = "/order")
    @ApiOperation(value = "Create a new order", response = Order.class)
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO){
        log.info("Inside post order ");

        Order order = new Order();
        ResponseMessage responseMessage = new ResponseMessage();
        List<OrderAddress> addressList = new ArrayList<>();

        if(orderDTO != null) {
            OrderAddress billingAddress = orderDTO.getBillingAddress();
            OrderAddress shipAddress = orderDTO.getShippingAddress();
            billingAddress.setType("Billing");
            shipAddress.setType("Shipping");
            order.setOrderStatus(OrderStatusEnum.NEW.getCode());
            order.setSub_total(orderDTO.getSub_total());
            order.setTax(orderDTO.getTax());
            order.setTotal(orderDTO.getTotal());
            order.setUserId(21L);
            order.setOrderDetails(orderDTO.getOrderDetailList());
            addressList.add(billingAddress);
            addressList.add(shipAddress);
            order.setAddressesList(addressList);
            order.setOrderPaymentList(orderDTO.getPayment_details());
            return ResponseEntity.ok(orderService.create(order));
        } else {
            responseMessage.setMessage("Post body incorrect");
            return new ResponseEntity<>(responseMessage,HttpStatus.BAD_REQUEST);
        }

    }
}
