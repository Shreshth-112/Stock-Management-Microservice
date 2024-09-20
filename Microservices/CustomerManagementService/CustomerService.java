package com.customer.customer.CustomerService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.customer.CustomerRepository.CustomerRepository;
import com.customer.customer.CustomersData.CustomerData;

@Service
public class CustomerService {





@Autowired
CustomerRepository repository;

public CustomerData saveCustomer(CustomerData customer) {
	return repository.save(customer);
}

public List<CustomerData> showAllCustomers(){
	return repository.findAll();
	
}




 // Getting data by id 
  public CustomerData getCustomerId(long Id){ 
	  return repository.findById(Id).get();
  
  } 
	
	
	  public  CustomerData updateCustomer(CustomerData customerDetails) {
		  return repository.save(customerDetails);
				  }
	  
	  
	 
  public void delete(long id) { 
	  repository.deleteById(id); }
	  

}
