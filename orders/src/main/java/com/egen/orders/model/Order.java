/**
 * 
 */
package com.egen.orders.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="orders")
public class Order implements Serializable { /**
	 * 
	 */
	private static final long serialVersionUID = 897910135897101046L;

// Master POJO Class for Order
	
	// Variables Start

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
    private Long orderId;
	
	@Column(name = "order_status")
    private String orderStatus;
	
	@Column(name = "customer_id")
    private Long customerId;
    
    @Column(name = "total")
    private Double total;

    @Column(name = "tax")
    private Double tax;

    @Column(name = "sub_total")
    private Double subTotal;

    @Basic(optional = false)
    @CreationTimestamp
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY,
            mappedBy = "order")
    private List<OrderInfo> orderDetails;

    @OneToMany(cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY,
            mappedBy = "order")
    private List<OrderAddress> addressesList;

    @OneToMany(cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER,
            mappedBy = "order")
    private List<OrderPayment> orderPaymentList;

    
	
    //Variables end
    
    //Constructor Start
	/**
	 * 
	 */
    public Order() {
        this.orderDetails = new ArrayList<>();
        this.addressesList = new ArrayList<>();
        this.orderPaymentList = new ArrayList<>();
    }



	/**
	 * @param orderId
	 * @param orderStatus
	 * @param customerId
	 * @param total
	 * @param tax
	 * @param subTotal
	 * @param createdAt
	 * @param updatedAt
	 */
	public Order(Long orderId, String orderStatus, Long customerId, Double total, Double tax, Double subTotal,
			Date createdAt, Date updatedAt) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.customerId = customerId;
		this.total = total;
		this.tax = tax;
		this.subTotal = subTotal;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	// Constructors end
	
	// Getters,setters start

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}



	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}



	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}



	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}



	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}



	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
	 * @return the subTotal
	 */
	public Double getSubTotal() {
		return subTotal;
	}



	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}



	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}



	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}



	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	/**
	 * @return the orderDetails
	 */
	public List<OrderInfo> getOrderDetails() {
		return orderDetails;
	}



	/**
	 * @param orderDetails the orderDetails to set
	 */
	public void setOrderDetails(List<OrderInfo> orderDetails) {
		this.orderDetails = orderDetails;
	}



	/**
	 * @return the addressesList
	 */
	public List<OrderAddress> getAddressesList() {
		return addressesList;
	}



	/**
	 * @param addressesList the addressesList to set
	 */
	public void setAddressesList(List<OrderAddress> addressesList) {
		this.addressesList = addressesList;
	}



	/**
	 * @return the orderPaymentList
	 */
	public List<OrderPayment> getOrderPaymentList() {
		return orderPaymentList;
	}



	/**
	 * @param orderPaymentList the orderPaymentList to set
	 */
	public void setOrderPaymentList(List<OrderPayment> orderPaymentList) {
		this.orderPaymentList = orderPaymentList;
	}
    
	
	// Getters, setters end
	
	
	
    
}
