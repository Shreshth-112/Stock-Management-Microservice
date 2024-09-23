package com.finalSprint.dispatch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.finalSprint.dispatch.exception.InvalidValueException;
import com.finalSprint.dispatch.feign.DispatchFeign;
import com.finalSprint.dispatch.model.Dispatch;
import com.finalSprint.dispatch.repository.DispatchRepository;
import com.finalSprint.dispatch.model.Product;

@Service
public class DispatchService {
	
	@Autowired
	private DispatchRepository dispatchRepository;
	
	@Autowired
	private DispatchFeign client;
	
	//add dispatch
	public Dispatch addDispatcher(Dispatch dispatch)throws InvalidValueException, Exception {
		
		if(dispatch.getProductName() == null | dispatch.getCustomerAddress() ==null | dispatch.getBillAmount() ==null) {
			throw new NullPointerException("Please Provide dispatch details");
		}
		return dispatchRepository.save(dispatch);
	}
	
	// view All
	public List<Dispatch> findAll(){
		return dispatchRepository.findAll();
	}
	
	// find by id
	public Dispatch getDispatcherById(Long id) throws InvalidValueException, Exception {
		return dispatchRepository.findById(id).orElseThrow(()-> new InvalidValueException("Dispatch details not found"));
	}
	
	// find by location
	public List<Dispatch> getDispatcherByAddress(String address) throws InvalidValueException, Exception  {
		if (address == null || address.isEmpty()) {
	        throw new InvalidValueException("Address cannot be null or empty");
	    }
	    List<Dispatch> dispatchers = dispatchRepository.findByCustomerAddress(address);
	    if (dispatchers.isEmpty()) {
	        throw new InvalidValueException("No dispatchers found for the given address");
	    }
	    return dispatchers;
	}
	
	// delete by id
	public void deleteDispatcher(long id) throws InvalidValueException, Exception {
		if(!dispatchRepository.existsById(id)) {
			throw new InvalidValueException("Dispatch details not found");
		}
		dispatchRepository.deleteById(id);
	}
	
	// update dispatcher
	public Dispatch updateDispatcher(long id, Dispatch dispatchDetails) {
		if(dispatchDetails.getProductName() == null | dispatchDetails.getCustomerAddress() ==null | dispatchDetails.getBillAmount() ==null) {
			throw new NullPointerException("Please Provide dispatch details");
		}
		Dispatch dispatch = dispatchRepository.findById(id).get();
		
		dispatch.setProductName(dispatchDetails.getProductName());
		dispatch.setCustomerAddress(dispatchDetails.getCustomerAddress());
		dispatch.setBillAmount(dispatchDetails.getBillAmount());
		
		return dispatchRepository.save(dispatch);
	}
	
//	---------------------------------------------------------------
	
	public ResponseEntity<Product> subtractProduct(Product product){
		return client.subtractProduct(product);
	}
}