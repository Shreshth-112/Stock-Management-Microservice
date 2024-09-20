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

import com.suppliers.model.Supplier;
import com.suppliers.services.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
	
	@Autowired
    SupplierService supplierService;

    @GetMapping("/getAllSuppliers")
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{SupplierById}")
    public Supplier getSupplierById(@PathVariable Long SupplierId) {
        return supplierService.getSupplierById(SupplierId);
    }

    @PostMapping("/createSupplier")
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return supplierService.createSupplier(supplier);
    }

    @PutMapping("/updateSupplierById/{SupplierId}")
    public ResponseEntity<Supplier> updateSupplierById(@PathVariable Long SupplierId, @RequestBody Supplier supplier) {
    	
    	supplier.setSupplierId(SupplierId);
        Supplier updatedSupplier = supplierService.updateSupplier(supplier);
        return ResponseEntity.ok(updatedSupplier);
    }

    @DeleteMapping("/deleteSupplierById/{SupplierId}")
    public void deleteSupplier(@PathVariable Long SupplierId) {
        supplierService.deleteSupplier(SupplierId);
    }

}
 