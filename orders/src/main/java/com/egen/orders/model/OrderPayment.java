/**
 * 
 */
package com.egen.orders.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * @author sanjaykhan
 *
 */
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "order_payment")
public class OrderPayment { // POJO class for order payment

	// Variables Start
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private Integer paymentId;

    @Column(name = "method")
    private String method;

    @Column(name = "date")
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;
    
    //variables end
    
    //constructors start

	/**
	 * 
	 */
	public OrderPayment() {
		super();
	}

	/**
	 * @param paymentId
	 * @param method
	 * @param date
	 * @param order
	 */
	public OrderPayment(Integer paymentId, String method, String date, Order order) {
		super();
		this.paymentId = paymentId;
		this.method = method;
		this.date = date;
		this.order = order;
	}

	//constructors end
	
	
	// getters, setters end
	/**
	 * @return the paymentId
	 */
	public Integer getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
    
    // getters , setters end
    
    

}
