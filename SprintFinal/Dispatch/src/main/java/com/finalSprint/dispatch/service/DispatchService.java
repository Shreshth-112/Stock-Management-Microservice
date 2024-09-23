package com.finalSprint.dispatch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
	public Dispatch addDispatcher(Dispatch dispatch) {
		return dispatchRepository.save(dispatch);
	}
	
	// view All
	public List<Dispatch> findAll(){
		return dispatchRepository.findAll();
	}
	
	// find by id
	public Dispatch getDispatcherById(Long id) {
		return dispatchRepository.findById(id).get();
	}
	
	// find by location
	public List<Dispatch> getDispatcherByAddress(String Address){
		return dispatchRepository.findByCustomerAddress(Address);
	}
	
	// delete by id
	public void deleteDispatcher(long id) {
		dispatchRepository.deleteById(id);
	}
	
	// update dispatcher
	public Dispatch updateDispatcher(long id, Dispatch dispatchDetails) {
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