package com.demo.customer1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.stereotype.Service;

import com.demo.customer1.feignClient.FeignInterface;
import com.demo.customer1.model.Customer1;
import com.demo.customer1.model.Product;
import com.demo.customer1.repository.Customer1Repository;

@Service
public class Customer1Services {
	
	@Autowired
	private Customer1Repository repository;
	
	@Autowired
	private FeignInterface client;
	
	public Customer1 saveCustomer(Customer1 c1) {
		return repository.save(c1);
	}
	
	public List<Customer1> findAll(){
		return repository.findAll();
	}
	
	public Customer1 getCustomer(Long id) {
		return repository.findById(id).get();
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public List<Product> findAllProducts(){
		return client.showProducts();
	}
}
