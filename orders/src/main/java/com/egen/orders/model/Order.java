/**
 * 
 */
package com.egen.orders.model;

/**
 * @author sanjaykhan
 *
 */
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name="orders")
public class Order implements Serializable {

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

	

	/**
	 * 
	 */
	public Order() {
		super();
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
    
    
}
