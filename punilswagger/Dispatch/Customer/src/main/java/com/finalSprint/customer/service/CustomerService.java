package com.finalSprint.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalSprint.customer.exceptions.InvalidValueException;
import com.finalSprint.customer.feignClient.CustomerFeign;
import com.finalSprint.customer.model.Customer;
import com.finalSprint.customer.model.Product;
import com.finalSprint.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private CustomerFeign client;
	
	public Customer saveCustomer(Customer c) throws InvalidValueException, Exception {
		if(c.getCustomerName()==null | c.getCustomerLocation()==null | c.getProductName()==null |c.getQuantity()==null) {
			throw new NullPointerException("Please enter the Customer details");
		}
		return repository.save(c);
	}
	
	public List<Customer> findAllCustomers(){
		return repository.findAll();
	}
	
	public Customer findCustomerById(Long id) throws InvalidValueException, Exception {
		return repository.findById(id).orElseThrow(()-> new InvalidValueException("Customer not found - Invalid id"));
	}
	
	public void deleteCustomer(Long id) throws InvalidValueException, Exception{
		if(!repository.existsById(id)) {
			throw new InvalidValueException("Customer not found- Invalid id");
		}
		repository.deleteById(id);
	}
	
//	---------------------------------------------------------
//	Methods for feign
	
	public List<Product> findAllProducts(){
		return client.showProducts();
	}
	
	
}
