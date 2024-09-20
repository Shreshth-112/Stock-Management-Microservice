package com.stockManagement.order.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockManagement.order.model.Order;
import com.stockManagement.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repository;
	
	public Order saveOrder(Order orders) {
		return repository.save(orders);
	}
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order getOrder(long orderId) {
		return repository.findById(orderId).get();
	}
	
	public void delete(long OrderId) {
		repository.deleteById(OrderId);
	}
}

