package com.suppliers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.entity.Product;
import com.suppliers.feign.ProductFeignClient;
import com.suppliers.model.Supplier;
import com.suppliers.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
    private SupplierRepository supplierRepository;
	
	@Autowired
    private ProductFeignClient productFeignClient;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long SupplierId) {
        return supplierRepository.findById(SupplierId).orElse(null);
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long SupplierId) {
        supplierRepository.deleteById(SupplierId);
    }
    
    public Product getProductById(long pid) {
        return productFeignClient.getProductById(pid);
    }

    public Product getProductByName(String name) {
        return productFeignClient.getProductByName(name);
    }

    public List<Product> getProductByPrice(double price) {
        return productFeignClient.getProductByPrice(price);
    }

    public List<Product> getProductLessThan(double price) {
        return productFeignClient.getProductLessThan(price);
    }

	public Product getProductByIdFromProductService(long productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
