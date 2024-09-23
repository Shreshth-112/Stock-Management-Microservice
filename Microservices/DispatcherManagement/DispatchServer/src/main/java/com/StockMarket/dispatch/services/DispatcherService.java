package com.StockMarket.dispatch.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StockMarket.dispatch.entity.Dispatcher;
import com.StockMarket.dispatch.repository.DispatchRepository;

@Service
public class DispatcherService {
	
	@Autowired
	DispatchRepository dispatchRepository;
	
	//add dispatch
	public Dispatcher addDispatcher(Dispatcher dispatch) {
		return dispatchRepository.save(dispatch);
	}
	
	// view All
	public List<Dispatcher> findAll(){
		return dispatchRepository.findAll();
	}
	
	// find by id
	public Dispatcher getDispatcherById(Long id) {
		return dispatchRepository.findById(id).get();
	}
	
	// find by location
	public List<Dispatcher> getDispatcherByAddress(String Address){
		return dispatchRepository.findByCustomerAddress(Address);
	}
	
	// delete by id
	public void deleteDispatcher(long id) {
		dispatchRepository.deleteById(id);
	}
	
	// update dispatcher
	public Dispatcher updateDispatcher(long id, Dispatcher dispatchDetails) {
		Dispatcher dispatch = dispatchRepository.findById(id).get();
		
		dispatch.setProductName(dispatchDetails.getProductName());
		dispatch.setCustomerAddress(dispatchDetails.getCustomerAddress());
		dispatch.setBillAmount(dispatchDetails.getBillAmount());
		
		return dispatchRepository.save(dispatch);
	}
}
