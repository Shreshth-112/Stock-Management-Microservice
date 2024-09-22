package com.demo.supplier.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.supplier.entity.Supplier;
import com.demo.supplier.feignClient.ProductClient;
import com.demo.supplier.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository repository;
	
	@Autowired
	private ProductClient productClient;
	
	public Supplier addOrUpdateProduct(Long supplierId,Long productId,Integer quantity) {
		Supplier supplierProduct = repository.findBySupplierId(supplierId).stream().filter(p->p.getProductId().equals(productId)).findFirst().orElse(new Supplier());
		
		supplierProduct.setSupplierId(supplierId);
		supplierProduct.setProductId(productId);
		supplierProduct.setQuantity(quantity);
		
		repository.save(supplierProduct);
		
		productClient.updateProductQuantity(productId, Map.of("quantity", quantity));
		
		return supplierProduct;
	}
	
	public List<Supplier> getProductsBySupplier(Long supplierId){
		return repository.findBySupplierId(supplierId);
	}
}
