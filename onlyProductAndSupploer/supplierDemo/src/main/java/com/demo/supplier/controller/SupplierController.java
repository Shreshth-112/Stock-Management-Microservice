package com.demo.supplier.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.supplier.entity.Supplier;
import com.demo.supplier.service.SupplierService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/supplier")
public class SupplierController {
	
	@Autowired
	private SupplierService service;
	
	@PostMapping("{supplierId}/product")
	public ResponseEntity<Supplier> addProductSupply(@PathVariable Long supplierId,@RequestBody Map<String, Object> productDetails) {
		//TODO: process POST request
		Long productId = Long.parseLong(productDetails.get("productId").toString());
		Integer quantity = Integer.parseInt(productDetails.get("quantity").toString());
		
		Supplier supplierProduct = service.addOrUpdateProduct(supplierId, productId, quantity);
		
		return ResponseEntity.ok(supplierProduct);
	}
	
	@GetMapping("/{supplierId}/products")
	public List<Supplier> getSuppliedProducts(@PathVariable Long supplierId){
		return service.getProductsBySupplier(supplierId);
	}
	
}
