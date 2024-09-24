package com.finalSprint.customer.controller;

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

import com.finalSprint.customer.exceptions.InvalidValueException;
import com.finalSprint.customer.model.Customer;
import com.finalSprint.customer.model.Product;
import com.finalSprint.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping
	public String message() {
		return "OK:200";
	}

	@GetMapping("/viewallcustomers")
	public List<Customer> showCustomers() {
		return service.findAllCustomers();
	}
 
	@PostMapping("/addcustomer")
	public Customer createProduct(@RequestBody Customer customer) throws InvalidValueException, Exception {
		return service.saveCustomer(customer);
	}

	@GetMapping("/customerid/{id}")
	public Customer getProduct(@PathVariable long id) throws InvalidValueException, Exception {// throws InvalidValueException{
		return service.findCustomerById(id);
	}

	@DeleteMapping("/customerdeletebyid/{id}")
	public void deleteCustomerData(@PathVariable long id) throws InvalidValueException, Exception {// throws InvalidValueException{
		service.deleteCustomer(id);
	}
	
	@PutMapping("/updatecustomer")
	public Customer updateCustomer(@RequestBody Customer customerDetails) throws InvalidValueException, Exception {
		return service.saveCustomer(customerDetails);
	}
	
	@GetMapping("/viewproducts")
	public List<Product> getAll() {
		return service.findAllProducts();
	}
}
