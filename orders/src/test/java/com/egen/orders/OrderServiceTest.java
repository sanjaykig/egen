package com.egen.orders;
/**
 * @author sanjaykhan
 *
 */

import static org.mockito.Mockito.*;
import com.egen.orders.model.OrderAddress;
import com.egen.orders.enums.Status;
import com.egen.orders.exception.ResourceNotFoundException;
import com.egen.orders.model.Order;
import com.egen.orders.model.OrderInfo;
import com.egen.orders.model.OrderPayment;
import com.egen.orders.repository.OrderAddressRepository;
import com.egen.orders.repository.OrderInfoRepository;
import com.egen.orders.repository.OrderPaymentRepository;
import com.egen.orders.repository.OrderRepository;
import com.egen.orders.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.verify;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderAddressRepository addressRepository;

    @Mock
    private OrderInfoRepository orderInfoRepository;

    @Mock
    private OrderPaymentRepository orderPaymentRepository;


    @InjectMocks
    private OrderServiceImpl orderService;
    
    private Order order;
    @BeforeEach
	public void setup() throws Exception {
		order = new Order();
		
		OrderInfo orderInfo= new OrderInfo();
        orderInfo.setId(777L);
        orderInfo.setItemName("Bread");
        orderInfo.setItemQty(4);
        orderInfo.setOrder(order);
        
        order.setOrderId(777L);
        order.setOrderId(77L);
		order.setSubTotal(55.0);
        order.setTotal(44.0);
        order.setTax(11.0);
        order.setOrderStatus(Status.STARTED.getStatus());
        
        OrderAddress orderAddressBilling = new OrderAddress();
        orderAddressBilling.setType("billing");
        orderAddressBilling.setAddressLine1("1357 Millersport Hwy");
        orderAddressBilling.setAddressLine2("APT 7");
        orderAddressBilling.setCity("Buffalo");
        orderAddressBilling.setState("NY");
        orderAddressBilling.setZip("14221");
        orderAddressBilling.setOrder(order);
        
        OrderAddress orderAddressShipping = new OrderAddress();
        orderAddressShipping.setType("shipping");
        orderAddressShipping.setAddressLine1("1357 Millersport Hwy");
        orderAddressShipping.setAddressLine2("APT 7");
        orderAddressShipping.setCity("Buffalo");
        orderAddressShipping.setState("NY");
        orderAddressShipping.setZip("14221");
        orderAddressShipping.setOrder(order);

        OrderPayment orderPayment = new OrderPayment();
        orderPayment.setDate("12/2/2021");
        orderPayment.setMethod("CASH");

        
        order.getAddressesList().add(orderAddressBilling);
        order.getAddressesList().add(orderAddressShipping);
        order.getOrderPaymentList().add(orderPayment);
        
        
        order.getAddressesList();
        List<OrderInfo> orderInfoList =new ArrayList<>();
        orderInfoList.add(orderInfo);
        
	    }
    
    
    @Test 
    void isOrderExistTest(){
    	 given(orderRepository.save(any(Order.class))).willReturn(order);
    	 given(orderRepository.findByOrderId(anyLong())).willReturn(order);
    	 orderService.createOrder(order);
         Boolean orderSample = orderService.isOrderExists(anyLong());
         verify(orderRepository).save(order);
         verify(orderRepository).existsByOrderId(anyLong());
         assertTrue(!orderSample);
    }
    
    
    @Test
    void getOrderByIdTest() throws ResourceNotFoundException {

    	given(orderRepository.findByOrderId(anyLong())).willReturn(order);
    	Order orderSample=orderService.getOrderById(anyLong());
    	verify(orderRepository).findByOrderId(anyLong());
    	assertEquals(order,orderSample);

    }
    
    @Test
    void createOrderTest() {
        given(orderRepository.save(any(Order.class))).willReturn(order);
        given(orderRepository.findByOrderId(anyLong())).willReturn(order);
        Order orderSample = orderService.createOrder(order);
        verify(orderRepository).save(order);
        verify(orderRepository).findByOrderId(anyLong());
        assertEquals(order, orderSample);


    }
   
    @Test
    void completeOrderTest() throws ResourceNotFoundException {
    	given(orderRepository.findByOrderId(anyLong())).willReturn(order);
    	given(orderRepository.save(any(Order.class))).willReturn(order);
    	Order completedorder=orderService.completeOrder(anyLong());
    	verify(orderRepository).save(order);
    	assertThat(completedorder.getOrderStatus()).isEqualTo(Status.COMPLETED.getStatus());
    }
    
    @Test
    void cancelOrderTest() throws ResourceNotFoundException {
    	given(orderRepository.findByOrderId(anyLong())).willReturn(order);
    	given(orderRepository.save(any(Order.class))).willReturn(order);
    	Order cancelledorder=orderService.cancelOrder(anyLong());
    	verify(orderRepository).save(order);
    	assertThat(cancelledorder.getOrderStatus()).isEqualTo(Status.CANCELLED.getStatus());
    }
    
    @Test
    void updateOrderTest() throws ResourceNotFoundException {
    	given(orderRepository.save(any(Order.class))).willReturn(order);
    	given(orderRepository.findByOrderId(anyLong())).willReturn(order);
    	Order orderSample = orderService.createOrder(order);
    	Order cancelledorder=orderService.updateOrder(orderSample);
    	assertEquals(order,cancelledorder);
    }
    
    
    @Test
    void saveBulkOrderTest() {
        given(orderRepository.save(any(Order.class))).willReturn(order);
        given(orderRepository.findByOrderId(anyLong())).willReturn(order);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        orderService.saveBulkOrder(orderList);
        verify(orderRepository).save(order);
        verify(orderRepository).findByOrderId(anyLong());
        assertNotNull(order);


    }
    
}