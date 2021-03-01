package com.egen.orders.repository;

import com.egen.orders.model.OrderAddress;
import com.egen.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<OrderAddress,Integer> {
    List<OrderAddress> findByOrder(Order order);
}
