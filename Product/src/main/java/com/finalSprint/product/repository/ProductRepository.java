package com.finalSprint.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalSprint.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByProductName(String productName);

	List<Product> findByProductPrice(double productPrice);

	List<Product> findByProductPriceLessThan(double productPrice);
}
 