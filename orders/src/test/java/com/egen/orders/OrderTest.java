/**
 * 
 */
package com.egen.orders;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.egen.orders.enums.Status;
import com.egen.orders.model.Order;
import com.egen.orders.model.OrderAddress;
import com.egen.orders.model.OrderInfo;
import com.egen.orders.model.OrderPayment;

/**
 * @author sanjaykhan
 *
 */

class OrderTest {

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
        order.setCustomerId(77L);
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
	void getOrderIdTest() {
		assertEquals(777L,order.getOrderId());
	}
	
	@Test
	void setOrderIdTest() {
		order.setOrderId(123L);
		assertEquals(123L,order.getOrderId());
	}
	
	@Test
	void getOrderStatusTest() {
		assertEquals(Status.STARTED.getStatus(),order.getOrderStatus());
	}
	
	@Test
	void setOrderStatusTest() {
		order.setOrderStatus(Status.COMPLETED.getStatus());
		assertEquals(Status.COMPLETED.getStatus(),order.getOrderStatus());
	}
	
	@Test
	void getCustomerIdTest() {
		assertEquals(77L,order.getCustomerId());
	}
	
	@Test
	void setCustomerIdTest() {
		order.setOrderStatus(Status.COMPLETED.getStatus());
		assertEquals(Status.COMPLETED.getStatus(),order.getOrderStatus());
	}

	@Test
	void getTotalTest() {
		assertEquals(44.0,order.getTotal());
	}
	
	@Test
	void setTotalTest() {
		order.setTotal(47.0);
		assertEquals(47.0,order.getTotal());
	}
	
	@Test
	void getTaxTest() {
		assertEquals(11.0,order.getTax());
	}
	
	@Test
	void setTaxTest() {
		order.setTax(12.0);
		assertEquals(12.0,order.getTax());
	}
	
	@Test
	void getSubTotalTest() {
		assertEquals(55.0,order.getSubTotal());
	}
	
	@Test
	void setSubTotalTest() {
		order.setSubTotal(50.0);
		assertEquals(50.0,order.getSubTotal());
	}
	
	@Test
	void getCreatedDateTest() {
		assertNull(order.getCreatedAt());
	}
	
	@Test
	void setCreatedDateTotalTest() {
		order.setCreatedAt(new Date());
		assertNotNull(order.getCreatedAt());
	}
	
	@Test
	void getUpdatedDateTest() {
		assertNull(order.getUpdatedAt());
	}
	
	@Test
	void setUpdatedDateTotalTest() {
		order.setUpdatedAt(new Date());
		assertNotNull(order.getUpdatedAt());
	}
	
	@Test
	void getOrderDetailsTest() {
		assertNotNull(order.getOrderDetails());
	}
	
	@Test
	void setOrderDetailsTest() {
		order.setOrderDetails(new ArrayList<OrderInfo>());
		assertNotNull(order.getOrderDetails());
	}
	
	@Test
	void getOrderAddressTest() {
		assertNotNull(order.getAddressesList());
	}
	
	@Test
	void setOrderAddressTest() {
		order.setAddressesList(new ArrayList<OrderAddress>());
		assertNotNull(order.getAddressesList());
	}
	
	@Test
	void getOrderPaymentTest() {
		assertNotNull(order.getOrderPaymentList());
	}
	
	@Test
	void setOrderPaymentTest() {
		order.setOrderPaymentList(new ArrayList<OrderPayment>());
		assertNotNull(order.getOrderPaymentList());
	}
}
