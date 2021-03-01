package com.egen.orders.repository;

import com.egen.orders.model.Order;
import com.egen.orders.model.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo,Integer> {// Repository Interface for Postgres via
	//JPA
    List<OrderInfo> findByOrder(Order order);
}
