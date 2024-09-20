package com.stockManagement.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stockManagement.order.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}

 