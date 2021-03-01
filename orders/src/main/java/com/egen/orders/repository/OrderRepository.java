/**
 * 
 */
package com.egen.orders.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egen.orders.model.Order;

/**
 * @author sanjaykhan
 *
 */

import com.egen.orders.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    Order findByOrderId(Long orderId);
    boolean existsByOrderId(Long orderId);
}