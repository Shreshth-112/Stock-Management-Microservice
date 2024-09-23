package com.product.product.controller;

import java.util.List;
import java.util.Optional;

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

import com.product.product.entity.Product;
import com.product.product.exception.InvalidValueException;
import com.product.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping
	public String getMessage() {
		
		return "OK:200";
	}
	
	// add products
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) throws InvalidValueException, Exception {
		return service.addOrUpdateProduct(product);
	}
	
	// subtract product
	@PostMapping("/subproduct")
	public ResponseEntity<Product> subtractProduct(@RequestBody Product product) throws InvalidValueException, Exception{
		Optional<Product> updateProduct = service.subtractProduct(product);
		return ResponseEntity.ok(updateProduct.get());
	}
	
	//view all products
	@GetMapping("/viewproducts")
	public List<Product> showProducts(){
		return service.findAll();
	}
	
	//filter by id
	@GetMapping("/byid/{pid}")
	public Product ProductById(@PathVariable ("pid") long pid) throws InvalidValueException, Exception {
		return service.getProductById(pid);
	}
	
	//filter by name
	@GetMapping("/byname/{name}")
	public Optional<Product> ProductByName(@PathVariable("name") String name) throws InvalidValueException, Exception {
		return service.getProductByName(name);
	}

	//filter by price
	@GetMapping("/byprice/{price}")
	public List<Product> ProductByPrice(@PathVariable("price") double price) {
		return service.getProductByPrice(price);
	}
	
	//filter products less than price
	@GetMapping("/productbelow/{price}")
	public List<Product> ProductLessThan(@PathVariable("price") double price){
		return service.getProductLessThan(price);
	}
	
	//update product
	@PutMapping("/update/{pid}")
	public ResponseEntity<Product> modifyProduct(@PathVariable long pid , @RequestBody Product productDetails) throws InvalidValueException, Exception {
		Product updateProduct = service.UpdateProduct(pid, productDetails);
		return ResponseEntity.ok(updateProduct);
	}
	
	//delete product by id
	@DeleteMapping("/delete/{pid}")
	public void deleteById(@PathVariable ("pid") long pid) throws InvalidValueException, Exception {
		service.deleteById(pid);
	}
	
	
}
