package com.finalSprint.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalSprint.product.exceptions.InvalidValueException;
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
	public Product getProductById(long pid) throws InvalidValueException, Exception {
		return repository.findById(pid).orElseThrow(() -> new InvalidValueException("Product not found"));
	}

	// filter by name
	public Optional<Product> getProductByName(String name) throws InvalidValueException, Exception {
		Optional<Product> product = repository.findByProductName(name);
		if (product.isPresent()) {
			return product;
		} else {
			throw new InvalidValueException("Product not found");
		}
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
	public Product UpdateProduct(long pid, Product productDetails) throws InvalidValueException, Exception {
		if (productDetails.getProductName() == null | productDetails.getProductPrice() == 0
				| productDetails.getQuantity() == 0) {
			throw new NullPointerException("Product cannot be null");
		}

		Product product = repository.findById(pid).get();

		product.setProductName(productDetails.getProductName());
		product.setProductPrice(productDetails.getProductPrice());
		product.setQuantity(productDetails.getQuantity());

		return repository.save(product);
	}

	// delete product
	public void deleteById(long pid) throws InvalidValueException, Exception {
		if (!repository.existsById(pid)) {
			throw new InvalidValueException("Product not found");
		}
		repository.deleteById(pid);
	}

	// add products
	public Product addOrUpdateProduct(Product product) throws InvalidValueException, Exception {

		if (product.getProductName() == null | product.getProductPrice() == 0 | product.getQuantity() == 0) {
			throw new NullPointerException("Product cannot be null");
		}

		Optional<Product> existingProduct = repository.findByProductName(product.getProductName());

		if (product.getQuantity() < 0) {
			throw new InvalidValueException("Quantity cannot be negative.");
		}
		if (existingProduct.isPresent()) {
			Product exprod = existingProduct.get();
			exprod.setQuantity(exprod.getQuantity() + product.getQuantity());
			return repository.save(exprod);
		} else {
			return repository.save(product);
		}

	}

	// subtract product
	public Optional<Product> subtractProduct(Product product) throws InvalidValueException, Exception {

		if (product.getProductName() == null | product.getProductPrice() == 0 | product.getQuantity() == 0) {
			throw new NullPointerException("Product cannot be null");
		}

		Optional<Product> existingProduct = repository.findByProductName(product.getProductName());

		if (existingProduct.isPresent()) {
			Product exproduct = existingProduct.get();
			if (exproduct.getQuantity() >= product.getQuantity()) {
				exproduct.setQuantity(exproduct.getQuantity() - product.getQuantity());
				return Optional.of(repository.save(exproduct));
			} else {
				// when quantity to subtract is greater than existing quantity
				throw new InvalidValueException("Insufficient quantity");

			}
		} else {
			// when product is not found
			throw new InvalidValueException("Product not found");
		}
	}

}
