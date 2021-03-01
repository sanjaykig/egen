/**
 * 
 */
package com.egen.orders.model;

/**
 * @author sanjaykhan
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;


@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Entity
public class OrderInfo { // POJO Class for Order Info

	//Variables Start
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_qty")
    private Integer itemQty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @JsonIgnore
    private Order order;
    
    // Variables End
    
    // Constructors Start

	/**
	 * 
	 */
	public OrderInfo() {
		super();
	}

	/**
	 * @param id
	 * @param itemName
	 * @param itemQty
	 * @param order
	 */
	public OrderInfo(Long id, String itemName, Integer itemQty, Order order) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemQty = itemQty;
		this.order = order;
	}
	
	// Constructors End
	
	// Getters , Setters Start

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemQty
	 */
	public Integer getItemQty() {
		return itemQty;
	}

	/**
	 * @param itemQty the itemQty to set
	 */
	public void setItemQty(Integer itemQty) {
		this.itemQty = itemQty;
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
    
    // Getters ,setters end

}
