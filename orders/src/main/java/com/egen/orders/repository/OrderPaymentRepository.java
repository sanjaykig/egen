package com.egen.orders.repository;

import com.egen.orders.model.Order;
import com.egen.orders.model.OrderPayment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPaymentRepository extends JpaRepository<OrderPayment,Integer> {// Repository Interface for Postgres via
	//JPA
	List<OrderPayment> findByOrder(Order order);
}
