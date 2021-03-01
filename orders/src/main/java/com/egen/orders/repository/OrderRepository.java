/**
 * 
 */
package com.egen.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egen.orders.model.Order;

/**
 * @author sanjaykhan
 *
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
