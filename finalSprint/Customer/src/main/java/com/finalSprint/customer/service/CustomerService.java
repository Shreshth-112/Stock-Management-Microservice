package com.finalSprint.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalSprint.customer.model.Customer;
import com.finalSprint.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	public Customer saveCustomer(Customer c) {
		return repository.save(c);
	}
	
	public List<Customer> findAllCustomers(){
		return repository.findAll();
	}
	
	public Customer findCustomerById(Long id) {
		return repository.findById(id).get();
	}
	
	public void deleteCustomer(Long id) {
		repository.deleteById(id);
	}
	
//	---------------------------------------------------------
//	Methods for feign
	
	
	
}