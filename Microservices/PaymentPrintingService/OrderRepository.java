package com.payment.Bill.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.Bill.Order.Order;



public interface OrderRepository extends JpaRepository<Order, Long> {
}
