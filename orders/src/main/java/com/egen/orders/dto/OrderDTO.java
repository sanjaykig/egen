/**
 * 
 */
package com.egen.orders.dto;

import java.util.List;

import com.egen.orders.model.OrderAddress;
import com.egen.orders.model.OrderInfo;
import com.egen.orders.model.OrderPayment;



/**
 * @author sanjaykhan
 *
 */

public class OrderDTO { // Data Transfer Object Class for Orders to use in controllers
	
	// Variables Start
    private OrderAddress billingAddress;
    private OrderAddress shippingAddress;
    private Double total;
    private Double tax;
    private Double subTotal;
    private String deliverType;
    private List<OrderPayment> payment_details;
    private List<OrderInfo> orderDetailList;
    
    
    // Variables end
    
    
    // Constructors start
    
    /**
	 * 
	 */
	public OrderDTO() {
		super();
	}
	/**
	 * @param billingAddress
	 * @param shippingAddress
	 * @param total
	 * @param tax
	 * @param subTotal
	 * @param deliverType
	 * @param payment_details
	 * @param orderDetailList
	 */
	public OrderDTO(OrderAddress billingAddress, OrderAddress shippingAddress, Double total, Double tax, Double subTotal,
			String deliverType, List<OrderPayment> payment_details, List<OrderInfo> orderDetailList) {
		super();
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		this.total = total;
		this.tax = tax;
		this.subTotal = subTotal;
		this.deliverType = deliverType;
		this.payment_details = payment_details;
		this.orderDetailList = orderDetailList;
	}
	
	// Constructors end
	
	
	//Getters , Setters Start
	
	/**
	 * @return the billingAddress
	 */
	public OrderAddress getBillingAddress() {
		return billingAddress;
	}
	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(OrderAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	/**
	 * @return the shippingAddress
	 */
	public OrderAddress getShippingAddress() {
		return shippingAddress;
	}
	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(OrderAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}
	/**
	 * @return the tax
	 */
	public Double getTax() {
		return tax;
	}
	/**
	 * @param tax the tax to set
	 */
	public void setTax(Double tax) {
		this.tax = tax;
	}
	/**
	 * @return the sub_total
	 */
	public Double getSubTotal() {
		return subTotal;
	}
	/**
	 * @param sub_total the sub_total to set
	 */
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	/**
	 * @return the deliverType
	 */
	public String getDeliverType() {
		return deliverType;
	}
	/**
	 * @param deliverType the deliverType to set
	 */
	public void setDeliverType(String deliverType) {
		this.deliverType = deliverType;
	}
	/**
	 * @return the payment_details
	 */
	public List<OrderPayment> getPaymentDetails() {
		return payment_details;
	}
	/**
	 * @param payment_details the payment_details to set
	 */
	public void setPaymentDetails(List<OrderPayment> payment_details) {
		this.payment_details = payment_details;
	}
	/**
	 * @return the orderDetailList
	 */
	public List<OrderInfo> getOrderDetailList() {
		return orderDetailList;
	}
	/**
	 * @param orderDetailList the orderDetailList to set
	 */
	public void setOrderDetailList(List<OrderInfo> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	
    
    // Getters, setters end
}
