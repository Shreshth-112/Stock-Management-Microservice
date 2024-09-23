package com.finalSprint.supplier.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalSprint.supplier.feignclient.SupplierFeign;
import com.finalSprint.supplier.model.Product;
import com.finalSprint.supplier.model.Supplier;
import com.finalSprint.supplier.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository repository;
	
	@Autowired
	private SupplierFeign client;
	
	public Supplier saveSupplier(Supplier supplier) {
		return repository.save(supplier);
	}
	
	public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }
	
	public Supplier getSupplierById(Long SupplierId) {
        return repository.findById(SupplierId).orElse(null);
    }
	
	public void deleteSupplier(Long SupplierId) {
        repository.deleteById(SupplierId);
    }
	
//	----------------------------------------------------------
	
	public Product addProduct(Product product) {
		return client.addProduct(product);
	}
	
	public List<Product> findAllProducts(){
		return client.showProducts();
	}
}
