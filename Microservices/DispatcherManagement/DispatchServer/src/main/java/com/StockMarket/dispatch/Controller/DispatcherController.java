package com.StockMarket.dispatch.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StockMarket.dispatch.entity.Dispatcher;
import com.StockMarket.dispatch.exceptions.InvalidValueException;
import com.StockMarket.dispatch.services.DispatcherService;

@RestController
@RequestMapping("/dispatcher")
public class DispatcherController {
	
	@Autowired //creates object
	DispatcherService dispatcherService;
	
	@GetMapping
	public String getMessage() {
		return "OK:200";
	}
	
	// Add Dispatcher
	@PostMapping("/addDispatcher")
	public Dispatcher addDispatcher(@RequestBody Dispatcher dispatch) throws InvalidValueException, Exception {
		return dispatcherService.addDispatcher(dispatch);
	}
	
	//view All
	@GetMapping("/viewall")
	public List<Dispatcher> ViewAll(){
		return dispatcherService.findAll();
	}
	
	// find by id
	@GetMapping("/byid/{id}")
	public Dispatcher DispatcherById(@PathVariable Long id) throws InvalidValueException, Exception {
		return dispatcherService.getDispatcherById(id);
	}
	
	// find by Address
	@GetMapping("/byaddress/{address}")
	public List<Dispatcher> DispatcherByAddress(@PathVariable String address) throws InvalidValueException, Exception{
		return dispatcherService.getDispatcherByAddress(address);
	}
	
	// delete
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) throws InvalidValueException, Exception {
		dispatcherService.deleteDispatcher(id);
	}
	
	//update dispatcher
	@PutMapping("/update/{id}")
	public ResponseEntity<Dispatcher> update(@PathVariable long id, @RequestBody Dispatcher dispatch) throws InvalidValueException, Exception{
		Dispatcher updateDispatch = dispatcherService.updateDispatcher(id, dispatch);
		return ResponseEntity.ok(updateDispatch);
	} 
}
