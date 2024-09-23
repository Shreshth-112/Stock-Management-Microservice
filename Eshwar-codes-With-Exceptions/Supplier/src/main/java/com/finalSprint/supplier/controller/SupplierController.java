package com.finalSprint.supplier.controller;

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

import com.finalSprint.supplier.exceptions.InvalidValueException;
import com.finalSprint.supplier.feignclient.SupplierFeign;
import com.finalSprint.supplier.model.Product;
import com.finalSprint.supplier.model.Supplier;
import com.finalSprint.supplier.services.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService service;
	
	@GetMapping
	public String message() {
		return "OK:200";
	}

	@GetMapping("/viewallsuppliers")
	public List<Supplier> getAllSuppliers() {
		return service.getAllSuppliers();
	}

	@GetMapping("/getsupplierbyid/{id}")
	public Supplier getSupplierById(@PathVariable Long id) throws InvalidValueException, Exception{
		return service.getSupplierById(id);
	}
	
	@PostMapping("/addsupplier")
	public Supplier createSupplier(@RequestBody Supplier supplier)throws InvalidValueException, Exception {
		return service.saveSupplier(supplier);
	}
	
	@DeleteMapping("/deleteSupplierById/{SupplierId}")
	public void deleteSupplier(@PathVariable Long id)throws InvalidValueException, Exception {
		service.deleteSupplier(id);
	}
	
//	-----------------------------------------------------------
	
	@PostMapping("/addproduct")
	public Product addproduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	@GetMapping("/viewproducts")
	public List<Product> getAll() {
		return service.findAllProducts();
	}
	


}
