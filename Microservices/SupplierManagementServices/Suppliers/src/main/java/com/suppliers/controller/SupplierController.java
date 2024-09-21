package com.suppliers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.entity.Product;
import com.suppliers.model.Supplier;
import com.suppliers.services.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
	
	@Autowired
    private SupplierService supplierService;

    @GetMapping("/getAllSuppliers")
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }
    
    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long supplierId) {
        Supplier supplier = supplierService.getSupplierById(supplierId);
        if (supplier == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(supplier);
    }

    // Create a new supplier
    @PostMapping("/createSupplier")
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        Supplier createdSupplier = supplierService.createSupplier(supplier);
        return ResponseEntity.ok(createdSupplier);
    }

    // Update a supplier by ID
    @PutMapping("/updateSupplierById/{supplierId}")
    public ResponseEntity<Supplier> updateSupplierById(@PathVariable Long supplierId, @RequestBody Supplier supplierDetails) {
        supplierDetails.setSupplierId(supplierId);  // Ensure the correct ID is set
        Supplier updatedSupplier = supplierService.updateSupplier(supplierDetails);
        return ResponseEntity.ok(updatedSupplier);
    }

    // Delete a supplier by ID
    @DeleteMapping("/deleteSupplierById/{supplierId}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long supplierId) {
        supplierService.deleteSupplier(supplierId);
        return ResponseEntity.noContent().build();
    }

    // Fetch product details from Product Microservice using Feign Client
    // Get product by ID
    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        Product product = supplierService.getProductById(productId);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    // Get product by name
    @GetMapping("/product/name/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        Product product = supplierService.getProductByName(name);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    // Get products by price
    @GetMapping("/product/price/{price}")
    public List<Product> getProductByPrice(@PathVariable double price) {
        return supplierService.getProductByPrice(price);
    }

    // Get products with price less than a certain value
    @GetMapping("/product/lessThanPrice/{price}")
    public List<Product> getProductLessThan(@PathVariable double price) {
        return supplierService.getProductLessThan(price);
    }
}

//    @GetMapping("/{SupplierById}")
//    public Supplier getSupplierById(@PathVariable Long SupplierId) {
//        return supplierService.getSupplierById(SupplierId);
//    }
//
//    @PostMapping("/createSupplier")
//    public Supplier createSupplier(@RequestBody Supplier supplier) {
//        return supplierService.createSupplier(supplier);
//    }
//
//    @PutMapping("/updateSupplierById/{SupplierId}")
//    public ResponseEntity<Supplier> updateSupplierById(@PathVariable Long SupplierId, @RequestBody Supplier supplier) {
//    	
//    	supplier.setSupplierId(SupplierId);
//        Supplier updatedSupplier = supplierService.updateSupplier(supplier);
//        return ResponseEntity.ok(updatedSupplier);
//    }
//
//    @DeleteMapping("/deleteSupplierById/{SupplierId}")
//    public void deleteSupplier(@PathVariable Long SupplierId) {
//        supplierService.deleteSupplier(SupplierId);
//    }
//    
//    

 