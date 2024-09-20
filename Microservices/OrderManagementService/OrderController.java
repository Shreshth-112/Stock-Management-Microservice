package com.stockManagement.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockManagement.order.model.Order;
import com.stockManagement.order.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService service;
	
	
	@GetMapping
	public String getMessage() {
		return "OK:200";
	}
	
	@PostMapping("/addOrder")
	public Order createProduct(@RequestBody Order order) {
		return service.saveOrder(order);
	}
	
	@GetMapping("/{orderId}")
	public Order getOrder(@PathVariable long orderId) {
		return service.getOrder(orderId);
	}
	
	@GetMapping("/viewAllOrders")
	public List<Order> showOrders(){
		return service.findAll();
	}
	
	@PutMapping("/updateOrder")
	public Order modifyOrder(@RequestBody Order order) {
		return service.saveOrder(order);
	}
	
	@DeleteMapping("/delete/{orderId}")
	public void removeOrder(@PathVariable long orderId) {
		service.delete(orderId);
	}
	
	
}
 