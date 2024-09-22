package com.demo.customer1.controller;

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

import com.demo.customer1.feignClient.FeignInterface;
import com.demo.customer1.model.Customer1;
import com.demo.customer1.model.Product;
import com.demo.customer1.service.Customer1Services;

@RestController
@RequestMapping("/customer")
public class Customer1Controller {
	
	@Autowired
	private Customer1Services service;
	
	@GetMapping
	public String sendMessage() {
		return "OK:200";
	}
	
	@GetMapping("/getcustomer/{id}")
	public Customer1 getCustomerById(@PathVariable Long id) {
		return service.getCustomer(id);
	}
	
	@GetMapping("/viewallcustomers")
	public List<Customer1> showCustomers() {
		return service.findAll();
	}
	
	@PostMapping("/addcustomer")
	public Customer1 saveCustomer(@RequestBody Customer1 customer) {
		return service.saveCustomer(customer);
	}
	
	@PutMapping("/update")
	public Customer1 modifyProduct(@RequestBody Customer1 c) {
		return service.saveCustomer(c);
	}
	
	@DeleteMapping("/delete/{pid}")
	public void removeCustomer(@PathVariable Long id) {
		service.delete(id);
	}
	
	@GetMapping("/viewallproducts")
	public List<Product> getAll() {
		return service.findAllProducts();
	}
	 
}
 