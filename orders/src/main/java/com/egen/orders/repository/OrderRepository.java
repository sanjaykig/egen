/**
 * 
 */
package com.egen.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egen.orders.model.Order;

/**
 * @author sanjaykhan
 *
 */
public interface OrderRepository extends JpaRepository<Order, Long>{

}
