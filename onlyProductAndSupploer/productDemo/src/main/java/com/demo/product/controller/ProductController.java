package com.demo.product.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.product.entity.Product;
import com.demo.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired

	private ProductService service;

	@PutMapping("/{productId}/quantity")
	public ResponseEntity<Product> updateProductQuantity(@PathVariable Long productId,
			@RequestBody Map<String, Integer> request) {

		Integer quantity = request.get("quantity");
		Product updatedProduct = service.updateProductQuantity(productId, quantity);

		return ResponseEntity.ok(updatedProduct);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductDetails(@PathVariable Long productId) {
		return ResponseEntity.ok(service.getProductDetails(productId));
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Map<String, Object> productDetails){
		Product product = new Product();
		product.setName(productDetails.get("name").toString());
		product.setQuantity(0);
		
		Product savedProduct = service.saveProduct(product);
		return ResponseEntity.ok(savedProduct);
	}
	
}
