package com.product.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.product.product.entity.Product;
import com.product.product.exception.InvalidValueException;
import com.product.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	//add products
	public Product addOrUpdateProduct(Product product) throws InvalidValueException, Exception {
		
		if (product == null) {
			throw new NullPointerException("Product cannot be null");
		}
		
		Optional<Product> existingProduct = productRepository.findByProductName(product.getProductName());

		if (product.getQuantity() < 0) {
            throw new InvalidValueException("Quantity cannot be negative.");
        }
        if (existingProduct.isPresent()) {
            Product exprod = existingProduct.get();
            exprod.setQuantity(exprod.getQuantity() + product.getQuantity());
            return productRepository.save(exprod);
        } else {
            return productRepository.save(product);
        }
        
	}
	
	//subtract product
	public Optional<Product> subtractProduct(Product product) throws InvalidValueException, Exception {
		
		if (product == null) {
            throw new NullPointerException("Product cannot be null.");
        }

		Optional<Product> existingProduct = productRepository.findByProductName(product.getProductName());
	
		if (existingProduct.isPresent()) {
			Product exproduct = existingProduct.get();
			if (exproduct.getQuantity() >= product.getQuantity()) {
				exproduct.setQuantity(exproduct.getQuantity() - product.getQuantity());
				return Optional.of(productRepository.save(exproduct));
			} else {
				// when quantity to subtract is greater than existing quantity
				throw new InvalidValueException("Insufficient quantity");

			}
		} else {
			// when product is not found
			throw new InvalidValueException("Product not found");
		}
	}

	
	//view all products
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	//filter by id
	public Product getProductById(long pid) throws InvalidValueException, Exception {
		return productRepository.findById(pid).orElseThrow(()-> new InvalidValueException("Product not found"));
	}
	
	//filter by name
	public Optional<Product> getProductByName(String name) throws InvalidValueException, Exception{
		Optional<Product> product = productRepository.findByProductName(name);
		if(product.isPresent()) {
			return product;
		} else {
			throw new InvalidValueException("Product not found");
		}
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
	public Product UpdateProduct(long pid, Product productDetails)throws InvalidValueException, Exception {
		if(productDetails == null) {
			throw new NullPointerException("Product details cannot be null");
		}
		Product product = productRepository.findById(pid).get();
		
		product.setProductName(productDetails.getProductName());
		product.setProductPrice(productDetails.getProductPrice());
		product.setQuantity(productDetails.getQuantity());
		
		return productRepository.save(product);
	}	
	
	//delete product
	public void deleteById(long pid) throws InvalidValueException, Exception {
		if(!productRepository.existsById(pid)) {
			throw new InvalidValueException("Product not found");
		}
		productRepository.deleteById(pid);
	}

}
