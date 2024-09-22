package com.demo.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.product.entity.Product;
import com.demo.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product updateProductQuantity(Long productId, Integer quantity) {
		Product product = repository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));
		
		product.setQuantity(product.getQuantity() + quantity);
		return repository.save(product);
	}
	
	public Product getProductDetails(Long productId) {
		return repository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));
	}
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
}
