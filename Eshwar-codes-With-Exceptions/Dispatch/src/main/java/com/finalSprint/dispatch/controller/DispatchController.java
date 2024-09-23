package com.finalSprint.dispatch.controller;

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

import com.finalSprint.dispatch.exception.InvalidValueException;
import com.finalSprint.dispatch.model.Dispatch;
import com.finalSprint.dispatch.model.Product;
import com.finalSprint.dispatch.service.DispatchService;

@RestController
@RequestMapping("/dispatch")
public class DispatchController {
	
	@Autowired //creates object
	private DispatchService service;
	
	@GetMapping
	public String getMessage() {
		return "OK:200";
	}
	
	// Add Dispatcher
	@PostMapping("/addDispatch")
	public Dispatch addDispatcher(@RequestBody Dispatch dispatch) throws InvalidValueException, Exception {
		return service.addDispatcher(dispatch);
	}
	
	//view All
	@GetMapping("/viewall")
	public List<Dispatch> ViewAll(){
		return service.findAll();
	}
	
	// find by id
	@GetMapping("/byid/{id}")
	public Dispatch DispatcherById(@PathVariable Long id) throws InvalidValueException, Exception {
		return service.getDispatcherById(id);
	}
	
	// find by Address
	@GetMapping("/byaddress/{address}")
	public List<Dispatch> DispatcherByAddress(@PathVariable String address) throws InvalidValueException, Exception{
		return service.getDispatcherByAddress(address);
	}
	
	// delete
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) throws InvalidValueException, Exception {
		service.deleteDispatcher(id);
	}
	
	//update dispatcher
	@PutMapping("/update/{id}")
	public ResponseEntity<Dispatch> update(@PathVariable long id, @RequestBody Dispatch dispatch) {
		Dispatch updateDispatch = service.updateDispatcher(id, dispatch);
		return ResponseEntity.ok(updateDispatch);
	} 
	
	@PostMapping("/subproduct")
	public ResponseEntity<Product> subProduct(@RequestBody Product product) {
		return service.subtractProduct(product);
	}
	
}