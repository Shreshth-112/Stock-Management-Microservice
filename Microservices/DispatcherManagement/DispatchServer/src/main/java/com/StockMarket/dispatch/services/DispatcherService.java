package com.StockMarket.dispatch.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StockMarket.dispatch.entity.Dispatcher;
import com.StockMarket.dispatch.exceptions.InvalidValueException;
import com.StockMarket.dispatch.repository.DispatchRepository;

@Service
public class DispatcherService {
	
	@Autowired
	DispatchRepository dispatchRepository;
	
	//add dispatch
	public Dispatcher addDispatcher(Dispatcher dispatch) throws InvalidValueException, Exception {
		if(dispatch == null) {
			throw new NullPointerException("Please Provide dispatch details");
		}
		return dispatchRepository.save(dispatch);
	}
	
	// view All
	public List<Dispatcher> findAll(){
		return dispatchRepository.findAll();
	}
	
	// find by id
	public Dispatcher getDispatcherById(Long id) throws InvalidValueException, Exception {
		return dispatchRepository.findById(id).orElseThrow(()-> new InvalidValueException("Dispatch details not found"));
	}
	
	// find by location
	public List<Dispatcher> getDispatcherByAddress(String address) throws InvalidValueException, Exception{
		
		if (address == null || address.isEmpty()) {
	        throw new InvalidValueException("Address cannot be null or empty");
	    }
	    List<Dispatcher> dispatchers = dispatchRepository.findByCustomerAddress(address);
	    if (dispatchers.isEmpty()) {
	        throw new InvalidValueException("No dispatchers found for the given address");
	    }
	    return dispatchers;
	}
	
	// delete by id
	public void deleteDispatcher(long id) throws InvalidValueException, Exception{
		if(!dispatchRepository.existsById(id)) {
			throw new InvalidValueException("Dispatch details not found");
		}
		dispatchRepository.deleteById(id);
	}
	
	// update dispatcher
	public Dispatcher updateDispatcher(long id, Dispatcher dispatchDetails) {
		
		if(dispatchDetails == null) {
			throw new NullPointerException("Details should not be null");
		}
		Dispatcher dispatch = dispatchRepository.findById(id).get();
		
		dispatch.setProductName(dispatchDetails.getProductName());
		dispatch.setCustomerAddress(dispatchDetails.getCustomerAddress());
		dispatch.setBillAmount(dispatchDetails.getBillAmount());
		
		return dispatchRepository.save(dispatch);
	}
}

