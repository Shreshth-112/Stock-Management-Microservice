package com.customer.customer.controller;

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

import com.customer.customer.CustomerService.CustomerService;
import com.customer.customer.CustomersData.CustomerData;

@RestController
@RequestMapping("/manageCustomer")
public class CustomerController {

	@Autowired
	CustomerService customer;

	@GetMapping("/viewAllCustomers")
	public List<CustomerData> showAllCustomers() {
		return customer.showAllCustomers();
	}

	@PostMapping("/addCustomer")
	public CustomerData createProduct(@RequestBody CustomerData customer1) {
		return customer.saveCustomer(customer1);
	}

	// Getting data by Id.

	@GetMapping("/customerId/{id}")
	public CustomerData getProduct(@PathVariable long id) {

		return customer.getCustomerId(id);

	}
	// updating the data

	
	
	@PutMapping("/updateCustomerById/{id}")
	public CustomerData updateCustomer(@PathVariable(value = "id") Long customerId, @RequestBody CustomerData customerDetails) {
	    CustomerData existingCustomer = customer.getCustomerId(customerId);
	    if (existingCustomer != null) {
	        existingCustomer.setCustomerName(customerDetails.getCustomerName());
	        existingCustomer.setCustomerAddress(customerDetails.getCustomerAddress());
	        existingCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
	        // Add other fields as necessary
	        return customer.updateCustomer(existingCustomer);
	    } else {
	        // Handle the case where the customer is not found
	        return null;
	    }
	}
	 
	
	
	  //delete by id
	  
	  @DeleteMapping("/customerDeleteById/{id}") 
	  public void deleteCustomerData(@PathVariable long id) { 
		  customer.delete(id); }
	  
	 

}