package com.product.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product.entity.Product;
import com.product.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	//add products
	public Product addOrUpdateProduct(Product product) {
		Optional<Product> existingProduct = productRepository.findByProductName(product.getProductName());

        if (existingProduct.isPresent()) {
            Product exprod = existingProduct.get();
            exprod.setQuantity(exprod.getQuantity() + product.getQuantity());
            return productRepository.save(exprod);
        } else {
            return productRepository.save(product);
        }
	}
	
	//subtract product
	public Optional<Product> subtractProduct(Product product) {
		Optional<Product> existingProduct = productRepository.findByProductName(product.getProductName());
	
		if (existingProduct.isPresent()) {
			Product exproduct = existingProduct.get();
			if (exproduct.getQuantity() >= product.getQuantity()) {
				exproduct.setQuantity(exproduct.getQuantity() - product.getQuantity());
				return Optional.of(productRepository.save(exproduct));
			} else {
				// when quantity to subtract is greater than existing quantity
				System.out.println("Insufficient quantity to subtract.");
				return Optional.empty();
			}
		} else {
			// when product is not found
			System.out.println("Product not found.");
			return Optional.empty();
		}
	}

	
	//view all products
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	//filter by id
	public Product getProductById(long pid) {
		return productRepository.findById(pid).get();
	}
	
	//filter by name
	public Optional<Product> getProductByName(String name) {
		return productRepository.findByProductName(name);
	}
	
	//filter by price
	public List<Product> getProductByPrice(double price) {
		return productRepository.findByProductPrice(price);
	}
	
	//filter products less than price
	public List<Product> getProductLessThan(double price){
		return productRepository.findByProductPriceLessThan(price);
	}
	

	
	//update product
	public Product UpdateProduct(long pid, Product productDetails){
		Product product = productRepository.findById(pid).get();
		
		product.setProductName(productDetails.getProductName());
		product.setProductPrice(productDetails.getProductPrice());
		product.setQuantity(productDetails.getQuantity());
		
		return productRepository.save(product);
	}	
	
	//delete product
	public void deleteById(long pid) {
		productRepository.deleteById(pid);
	}

}
