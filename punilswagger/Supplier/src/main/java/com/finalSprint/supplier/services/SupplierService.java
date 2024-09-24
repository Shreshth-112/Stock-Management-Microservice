package com.finalSprint.supplier.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalSprint.supplier.exceptions.InvalidValueException;
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
	
	public Supplier saveSupplier(Supplier supplier)throws InvalidValueException, Exception {
		if(supplier.getId()==null |  supplier.getProductname()==null | supplier.getQuantity()==null) {
			throw new NullPointerException("Please enter the Supplier details");
		}
		return repository.save(supplier);
	}
	
	public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }
	
	public Supplier getSupplierById(Long SupplierId) throws InvalidValueException, Exception{
        return repository.findById(SupplierId).orElseThrow(()-> new InvalidValueException("Supplier not found - Invalid id"));
    }
	
	public void deleteSupplier(Long SupplierId) throws InvalidValueException, Exception {
		if(!repository.existsById(SupplierId)) {
			throw new InvalidValueException("Supplier not found- Invalid id");
		}
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
