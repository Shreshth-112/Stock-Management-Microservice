package com.finalSprint.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalSprint.product.model.Product;
import com.finalSprint.product.repository.ProductRepository;
 
@Service
public class ProductServices {

	@Autowired
	private ProductRepository repository;

	// view all products
	public List<Product> findAll() {
		return repository.findAll();
	}

	// filter by id
	public Product getProductById(long pid) {
		return repository.findById(pid).get();
	}

	// filter by name
	public Optional<Product> getProductByName(String name) {
		return repository.findByProductName(name);
	}

	// filter by price
	public List<Product> getProductByPrice(double price) {
		return repository.findByProductPrice(price);
	}

	// filter products less than price
	public List<Product> getProductLessThan(double price) {
		return repository.findByProductPriceLessThan(price);
	}
	
	// update product
	public Product UpdateProduct(long pid, Product productDetails) {
		Product product = repository.findById(pid).get();

		product.setProductName(productDetails.getProductName());
		product.setProductPrice(productDetails.getProductPrice());
		product.setQuantity(productDetails.getQuantity());

		return repository.save(product);
	}

	// delete product
	public void deleteById(long pid) {
		repository.deleteById(pid);
	}

	// add products
	public Product addOrUpdateProduct(Product product) {
		Optional<Product> existingProduct = repository.findByProductName(product.getProductName());

		if (existingProduct.isPresent()) {
			Product exprod = existingProduct.get();
			exprod.setQuantity(exprod.getQuantity() + product.getQuantity());
			return repository.save(exprod);
		} else {
			return repository.save(product);
		}
	}

	// subtract product
	public Optional<Product> subtractProduct(Product product) {
		Optional<Product> existingProduct = repository.findByProductName(product.getProductName());

		if (existingProduct.isPresent()) {
			Product exproduct = existingProduct.get();
			if (exproduct.getQuantity() >= product.getQuantity()) {
				exproduct.setQuantity(exproduct.getQuantity() - product.getQuantity());
				return Optional.of(repository.save(exproduct));
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


}
